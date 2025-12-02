package com.irctc.app.cache;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.irctc.app.entity.Train;
import com.irctc.app.repository.TrainRepository;

@DisplayName("TrainCache Unit Tests")
class TrainCacheTest {

	@Mock
	private TrainRepository trainRepository;

	@InjectMocks
	private TrainCache trainCache;

	private Train train1;
	private Train train2;
	private List<Train> trainList;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);

		// Create test data
		train1 = new Train();
		train1.setId(1);
		train1.setTrainNumber(12345);
		train1.setTrainName("Express");
		train1.setSource("Delhi");
		train1.setDestination("Mumbai");
		train1.setTime(LocalTime.of(10, 30));

		train2 = new Train();
		train2.setId(2);
		train2.setTrainNumber(54321);
		train2.setTrainName("Local");
		train2.setSource("Mumbai");
		train2.setDestination("Pune");
		train2.setTime(LocalTime.of(14, 45));

		trainList = new ArrayList<>();
		trainList.add(train1);
		trainList.add(train2);
	}

	@Test
	@DisplayName("Should fetch all trains on startup and populate cache")
	void testFetchAllTrainsOnStartUp() {
		// Arrange
		when(trainRepository.findAll()).thenReturn(trainList);

		// Act
		trainCache.fetchAllTrainsOnStartUp();

		// Assert
		verify(trainRepository, times(1)).findAll();
		assertTrue(trainCache.check(1));
		assertTrue(trainCache.check(2));
		assertEquals(train1, trainCache.getTrain(1));
		assertEquals(train2, trainCache.getTrain(2));
	}

	@Test
	@DisplayName("Should return true when train ID exists in cache")
	void testCheckTrainExists() {
		// Arrange
		trainCache.storeTrain(train1);

		// Act
		boolean result = trainCache.check(1);

		// Assert
		assertTrue(result);
	}

	@Test
	@DisplayName("Should return false when train ID does not exist in cache")
	void testCheckTrainNotExists() {
		// Act
		boolean result = trainCache.check(999);

		// Assert
		assertFalse(result);
	}

	@Test
	@DisplayName("Should store train in cache")
	void testStoreTrain() {
		// Act
		trainCache.storeTrain(train1);

		// Assert
		assertTrue(trainCache.check(1));
		assertEquals(train1, trainCache.getTrain(1));
	}

	@Test
	@DisplayName("Should store multiple trains in cache")
	void testStoreMultipleTrains() {
		// Act
		trainCache.storeTrain(train1);
		trainCache.storeTrain(train2);

		// Assert
		assertTrue(trainCache.check(1));
		assertTrue(trainCache.check(2));
		assertEquals(train1, trainCache.getTrain(1));
		assertEquals(train2, trainCache.getTrain(2));
	}

	@Test
	@DisplayName("Should retrieve train from cache")
	void testGetTrain() {
		// Arrange
		trainCache.storeTrain(train1);

		// Act
		Train retrievedTrain = trainCache.getTrain(1);

		// Assert
		assertNotNull(retrievedTrain);
		assertEquals(train1.getId(), retrievedTrain.getId());
		assertEquals(train1.getTrainName(), retrievedTrain.getTrainName());
	}

	@Test
	@DisplayName("Should return null when retrieving non-existent train")
	void testGetTrainNotFound() {
		// Act
		Train retrievedTrain = trainCache.getTrain(999);

		// Assert
		assertNull(retrievedTrain);
	}

	@Test
	@DisplayName("Should clear all trains from cache")
	void testClear() {
		// Arrange
		trainCache.storeTrain(train1);
		trainCache.storeTrain(train2);
		assertTrue(trainCache.check(1));
		assertTrue(trainCache.check(2));

		// Act
		trainCache.clear();

		// Assert
		assertFalse(trainCache.check(1));
		assertFalse(trainCache.check(2));
		assertNull(trainCache.getTrain(1));
		assertNull(trainCache.getTrain(2));
	}

	@Test
	@DisplayName("Should update existing train in cache")
	void testUpdateTrainInCache() {
		// Arrange
		trainCache.storeTrain(train1);

		// Act - Update train
		Train updatedTrain = new Train();
		updatedTrain.setId(1);
		updatedTrain.setTrainNumber(99999);
		updatedTrain.setTrainName("Updated Express");
		updatedTrain.setSource("Bangalore");
		updatedTrain.setDestination("Chennai");
		updatedTrain.setTime(LocalTime.of(20, 0));

		trainCache.storeTrain(updatedTrain);

		// Assert
		Train retrieved = trainCache.getTrain(1);
		assertEquals("Updated Express", retrieved.getTrainName());
		assertEquals(99999, retrieved.getTrainNumber());
	}

	@Test
	@DisplayName("Should handle empty cache initialization")
	void testEmptyCache() {
		// Act
		when(trainRepository.findAll()).thenReturn(new ArrayList<>());
		trainCache.fetchAllTrainsOnStartUp();

		// Assert
		assertFalse(trainCache.check(1));
		assertNull(trainCache.getTrain(1));
	}
}
