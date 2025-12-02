package com.irctc.app.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalTime;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.TestPropertySource;

import com.irctc.app.entity.Train;

@DataJpaTest
@DisplayName("TrainRepository Unit Tests")
@TestPropertySource(properties = {"spring.datasource.url=jdbc:h2:mem:testdb;MODE=PostgreSQL"})
class TrainRepositoryTest {

	@Autowired
	private TrainRepository trainRepository;

	@Autowired
	private TestEntityManager entityManager;

	@Test
	@DisplayName("Should save a single train successfully")
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
	@DisplayName("Should save and find train")
	public void testSaveAndFindTrain() {
		Train train = new Train();
		train.setTrainName("Rajdhani Express");
		train.setTrainNumber(17112);
		train.setDestination("Pune");
		train.setSource("Nanded");
		train.setTime(LocalTime.of(18, 30));

		Train saved = trainRepository.save(train);
		assertTrue(saved.getId() > 0);

		Train found = trainRepository.findById(saved.getId()).get();
		assertEquals("Rajdhani Express", found.getTrainName());
	}

	@Test
	@DisplayName("Should retrieve train by ID")
	public void testFindById() {
		// Arrange
		Train train = new Train();
		train.setTrainNumber(54321);
		train.setTrainName("Local");
		train.setSource("Mumbai");
		train.setDestination("Pune");
		train.setTime(LocalTime.of(14, 45));

		Train savedTrain = trainRepository.save(train);
		entityManager.flush();

		// Act
		Optional<Train> retrievedTrain = trainRepository.findById(savedTrain.getId());

		// Assert
		assertTrue(retrievedTrain.isPresent());
		assertEquals(54321, retrievedTrain.get().getTrainNumber());
		assertEquals("Local", retrievedTrain.get().getTrainName());
	}

	@Test
	@DisplayName("Should return empty Optional when train not found by ID")
	public void testFindByIdNotFound() {
		// Act
		Optional<Train> retrievedTrain = trainRepository.findById(9999);

		// Assert
		assertFalse(retrievedTrain.isPresent());
	}

	@Test
	@DisplayName("Should delete train by ID")
	public void testDeleteById() {
		// Arrange
		Train train = new Train();
		train.setTrainNumber(11111);
		train.setTrainName("SuperFast");
		train.setSource("Bangalore");
		train.setDestination("Chennai");
		train.setTime(LocalTime.of(22, 0));

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

	@Test
	@DisplayName("Should check train existence by ID")
	public void testExistsById() {
		// Arrange
		Train train = new Train();
		train.setTrainNumber(99999);
		train.setTrainName("Test");
		train.setSource("Test1");
		train.setDestination("Test2");
		train.setTime(LocalTime.of(12, 0));

		Train savedTrain = trainRepository.save(train);
		int trainId = savedTrain.getId();
		entityManager.flush();

		// Act
		boolean exists = trainRepository.existsById(trainId);

		// Assert
		assertTrue(exists);
	}

	@Test
	@DisplayName("Should update train successfully")
	public void testUpdateTrain() {
		// Arrange
		Train train = new Train();
		train.setTrainNumber(55555);
		train.setTrainName("Original");
		train.setSource("Source");
		train.setDestination("Destination");
		train.setTime(LocalTime.of(8, 0));

		Train savedTrain = trainRepository.save(train);
		int trainId = savedTrain.getId();
		entityManager.flush();

		// Act
		savedTrain.setTrainName("Updated");
		savedTrain.setDestination("NewDest");
		trainRepository.save(savedTrain);
		entityManager.flush();

		// Assert
		Optional<Train> retrievedTrain = trainRepository.findById(trainId);
		assertTrue(retrievedTrain.isPresent());
		assertEquals("Updated", retrievedTrain.get().getTrainName());
		assertEquals("NewDest", retrievedTrain.get().getDestination());
	}

	@Test
	@DisplayName("Should save and retrieve train with all fields")
	public void testSaveAndRetrieveCompleteTrainData() {
		// Arrange
		Train train = new Train();
		train.setTrainNumber(88888);
		train.setTrainName("Complete");
		train.setSource("StartPoint");
		train.setDestination("EndPoint");
		train.setTime(LocalTime.of(23, 59));

		// Act
		Train savedTrain = trainRepository.save(train);
		entityManager.flush();
		Optional<Train> retrievedTrain = trainRepository.findById(savedTrain.getId());

		// Assert
		assertTrue(retrievedTrain.isPresent());
		Train retrieved = retrievedTrain.get();
		assertEquals(88888, retrieved.getTrainNumber());
		assertEquals("Complete", retrieved.getTrainName());
		assertEquals("StartPoint", retrieved.getSource());
		assertEquals("EndPoint", retrieved.getDestination());
		assertEquals(LocalTime.of(23, 59), retrieved.getTime());
	}
}
