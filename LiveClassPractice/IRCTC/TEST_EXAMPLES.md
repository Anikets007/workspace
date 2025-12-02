# Test Examples - IRCTC Unit Tests

## 1. Entity Layer Test Example (TrainTest.java)

```java
@Test
@DisplayName("Train getter and setter should work correctly for all fields")
public void testTrainWithAllFields() {
    // Arrange
    Train train = new Train();
    
    // Act
    train.setId(1);
    train.setTrainNumber(12345);
    train.setTrainName("Express");
    train.setSource("Delhi");
    train.setDestination("Mumbai");
    train.setTime(LocalTime.of(10, 30));
    
    // Assert
    assertEquals(1, train.getId());
    assertEquals(12345, train.getTrainNumber());
    assertEquals("Express", train.getTrainName());
    assertEquals("Delhi", train.getSource());
    assertEquals("Mumbai", train.getDestination());
    assertEquals(LocalTime.of(10, 30), train.getTime());
}
```

## 2. Service Layer Test Example (TrainServiceTest.java)

```java
@Test
@DisplayName("Service should add train and call repository save")
void testAddTrain() {
    // Arrange
    Train train = new Train();
    train.setTrainNumber(12345);
    train.setTrainName("Express");
    
    // Act
    trainService.addTrain(train);
    
    // Assert - Verify repository was called
    verify(trainRepository, times(1)).save(train);
}

@Test
@DisplayName("Service should handle train not found exception")
void testGetTrainNotFound() {
    // Arrange
    when(trainRepository.findById(999)).thenReturn(Optional.empty());
    
    // Act & Assert
    assertThrows(RuntimeException.class, () -> {
        trainService.getTrain(999);
    });
}
```

## 3. Cache Layer Test Example (TrainCacheTest.java)

```java
@Test
@DisplayName("Cache should store and retrieve trains")
void testStoreTrain() {
    // Arrange
    Train train = new Train();
    train.setId(1);
    train.setTrainNumber(12345);
    train.setTrainName("Express");
    
    // Act
    trainCache.storeTrain(train);
    Train retrieved = trainCache.getTrain(1);
    
    // Assert
    assertNotNull(retrieved);
    assertEquals(12345, retrieved.getTrainNumber());
}

@Test
@DisplayName("Cache should clear all trains")
void testClear() {
    // Arrange
    Train train = new Train();
    train.setId(1);
    trainCache.storeTrain(train);
    
    // Act
    trainCache.clear();
    
    // Assert
    assertFalse(trainCache.check(1));
}
```

## 4. Controller Layer Test Example (TrainControllerTest.java)

```java
@Test
@DisplayName("POST /addTrain should return 201 CREATED")
void testAddTrain() throws Exception {
    // Arrange
    Train train = new Train();
    train.setId(1);
    train.setTrainNumber(12345);
    train.setTrainName("Express");
    train.setSource("Delhi");
    train.setDestination("Mumbai");
    train.setTime(LocalTime.of(10, 30));
    
    doNothing().when(trainService).addTrain(any());
    
    // Act & Assert
    mockMvc.perform(post("/addTrain")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(train)))
            .andExpect(status().isCreated())
            .andExpect(content().string(containsString("Train added successfully")));
    
    verify(trainService, times(1)).addTrain(any());
}

@Test
@DisplayName("GET /train/{id} should return train with correct fields")
void testGetTrain() throws Exception {
    // Arrange
    Train train = new Train();
    train.setId(1);
    train.setTrainName("Express");
    train.setTrainNumber(12345);
    
    when(trainService.getTrain(1)).thenReturn(train);
    
    // Act & Assert
    mockMvc.perform(get("/train/{id}", 1))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.id", is(1)))
            .andExpect(jsonPath("$.trainName", is("Express")))
            .andExpect(jsonPath("$.trainNumber", is(12345)));
}

@Test
@DisplayName("GET /trains should return all trains as array")
void testGetAllTrains() throws Exception {
    // Arrange
    List<Train> trains = new ArrayList<>();
    Train train1 = new Train();
    train1.setId(1);
    train1.setTrainName("Express");
    
    trains.add(train1);
    
    when(trainService.getAllTrains()).thenReturn(trains);
    
    // Act & Assert
    mockMvc.perform(get("/trains"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$", hasSize(1)))
            .andExpect(jsonPath("$[0].trainName", is("Express")));
}
```

## 5. Repository Layer Test Example (TrainRepositoryTest.java)

```java
@Test
@DisplayName("Repository should save and retrieve train")
public void testSaveTrain() {
    // Arrange
    Train train = new Train();
    train.setTrainNumber(12345);
    train.setTrainName("Express");
    train.setSource("Delhi");
    train.setDestination("Mumbai");
    train.setTime(LocalTime.of(10, 30));
    
    // Act
    Train savedTrain = trainRepository.save(train);
    entityManager.flush();
    
    // Assert
    assertNotNull(savedTrain.getId());
    assertEquals(12345, savedTrain.getTrainNumber());
    assertEquals("Express", savedTrain.getTrainName());
}

@Test
@DisplayName("Repository should update existing train")
public void testUpdateTrain() {
    // Arrange
    Train train = new Train();
    train.setTrainNumber(55555);
    train.setTrainName("Original");
    
    Train savedTrain = trainRepository.save(train);
    int trainId = savedTrain.getId();
    entityManager.flush();
    
    // Act
    savedTrain.setTrainName("Updated");
    trainRepository.save(savedTrain);
    entityManager.flush();
    
    // Assert
    Optional<Train> updatedTrain = trainRepository.findById(trainId);
    assertTrue(updatedTrain.isPresent());
    assertEquals("Updated", updatedTrain.get().getTrainName());
}

@Test
@DisplayName("Repository should delete train by ID")
public void testDeleteById() {
    // Arrange
    Train train = new Train();
    train.setTrainNumber(11111);
    train.setTrainName("SuperFast");
    
    Train savedTrain = trainRepository.save(train);
    int trainId = savedTrain.getId();
    entityManager.flush();
    
    // Act
    trainRepository.deleteById(trainId);
    entityManager.flush();
    
    // Assert
    Optional<Train> deletedTrain = trainRepository.findById(trainId);
    assertFalse(deletedTrain.isPresent());
}
```

## Test Data Builders

For more maintainable tests, create builder methods:

```java
private Train createTestTrain(int id, int number, String name) {
    Train train = new Train();
    train.setId(id);
    train.setTrainNumber(number);
    train.setTrainName(name);
    return train;
}

// Usage in tests
Train train = createTestTrain(1, 12345, "Express");
```

## Common Assertions

```java
// Value assertions
assertEquals(expected, actual);
assertNotEquals(notExpected, actual);
assertTrue(condition);
assertFalse(condition);

// Null/existence assertions
assertNull(object);
assertNotNull(object);

// Exception assertions
assertThrows(Exception.class, () -> {
    // code that should throw
});

// Collection assertions
assertTrue(list.contains(item));
assertEquals(size, list.size());
assertTrue(list.isEmpty());
```

## Common Mockito Patterns

```java
// Stubbing
when(mock.method()).thenReturn(value);
doNothing().when(mock).method();
doThrow(exception).when(mock).method();

// Verification
verify(mock, times(1)).method();
verify(mock, never()).method();
verify(mock, atLeast(1)).method();
verify(mock, atMostOnce()).method();

// ArgumentMatchers
verify(mock).method(any());
verify(mock).method(eq(value));
verify(mock).method(argThat(matcher));
```

## Running Tests from Command Line

```bash
# Run all tests
mvn clean test

# Run single test class
mvn test -Dtest=TrainServiceTest

# Run single test method
mvn test -Dtest=TrainServiceTest#testAddTrain

# Run tests matching pattern
mvn test -Dtest=Train*

# Run with specific profile
mvn test -Dspring.profiles.active=test

# Run with debug logging
mvn test -X

# Generate coverage report
mvn test jacoco:report
# View: target/site/jacoco/index.html
```

## Test Best Practices Applied

✅ **Descriptive Names** - Test names clearly describe what is being tested
✅ **Arrange-Act-Assert** - Clear separation of test phases
✅ **One Assertion** - Tests focus on one behavior
✅ **Isolation** - Tests don't depend on other tests
✅ **Mocking** - External dependencies are mocked
✅ **Edge Cases** - Null, empty, boundary conditions tested
✅ **Readable** - Easy to understand test intent
✅ **Fast** - Tests complete in milliseconds
✅ **Repeatable** - Same result every time
✅ **Self-Documenting** - Tests serve as documentation

