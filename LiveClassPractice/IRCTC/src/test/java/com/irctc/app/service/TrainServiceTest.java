package com.irctc.app.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.irctc.app.entity.Train;
import com.irctc.app.repository.TrainRepository;

@ExtendWith(MockitoExtension.class)
@DisplayName("TrainService Unit Tests")
public class TrainServiceTest {

	@InjectMocks
	private TrainServiceImpl trainServiceImpl;
	
	@Mock
	private TrainRepository trainRepository;

	private Train train1;
	private Train train2;
	private Train train3;
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

		train3 = new Train();
		train3.setId(3);
		train3.setTrainNumber(17226);
		train3.setTrainName("Pune-Nanded Express");
		train3.setSource("Nanded");
		train3.setDestination("Pune");
		train3.setTime(LocalTime.of(17, 0));

		trainList = new ArrayList<>();
		trainList.add(train1);
		trainList.add(train2);
		trainList.add(train3);
	}

	@Test
	@DisplayName("Should add a single train successfully")
	public void testAddTrain() {
		// Arrange
		when(trainRepository.save(train1)).thenReturn(train1);

		// Act
		trainServiceImpl.addTrain(train1);

		// Assert
		verify(trainRepository, times(1)).save(train1);
	}

	@Test
	@DisplayName("Should add a train with all fields populated")
	public void testAddTrainTest() {
		Train train = new Train();
		train.setId(1);
		train.setTrainNumber(17226);
		train.setTrainName("Pune-Nanded Express");
		train.setDestination("Pune");
		train.setSource("Nanded");
		train.setTime(LocalTime.of(17, 0));
		
		when(trainRepository.save(train)).thenReturn(train);
		
		trainServiceImpl.addTrain(train);
		
		verify(trainRepository, times(1)).save(train);
	}

	@Test
	@DisplayName("Should add multiple trains successfully")
	public void testAddTrains() {
		// Arrange
		when(trainRepository.saveAll(trainList)).thenReturn(trainList);

		// Act
		trainServiceImpl.addTrains(trainList);

		// Assert
		verify(trainRepository, times(1)).saveAll(trainList);
	}

	@Test
	@DisplayName("Should add empty list of trains")
	public void testAddEmptyTrainsList() {
		// Arrange
		List<Train> emptyList = new ArrayList<>();
		when(trainRepository.saveAll(emptyList)).thenReturn(emptyList);

		// Act
		trainServiceImpl.addTrains(emptyList);

		// Assert
		verify(trainRepository, times(1)).saveAll(emptyList);
	}

	@Test
	@DisplayName("Should delete a train by ID")
	public void testDeleteTrain() {
		// Arrange
		int trainId = 1;

		// Act
		trainServiceImpl.deleteTrain(trainId);

		// Assert
		verify(trainRepository, times(1)).deleteById(trainId);
	}

	@Test
	@DisplayName("Should delete multiple trains")
	public void testDeleteMultipleTrains() {
		// Act
		trainServiceImpl.deleteTrain(1);
		trainServiceImpl.deleteTrain(2);
		trainServiceImpl.deleteTrain(3);

		// Assert
		verify(trainRepository, times(1)).deleteById(1);
		verify(trainRepository, times(1)).deleteById(2);
		verify(trainRepository, times(1)).deleteById(3);
		verify(trainRepository, times(3)).deleteById(anyInt());
	}

	@Test
	@DisplayName("Should retrieve a train by ID")
	public void testGetTrain() {
		// Arrange
		int trainId = 1;
		when(trainRepository.findById(trainId)).thenReturn(Optional.of(train1));

		// Act
		Train retrievedTrain = trainServiceImpl.getTrain(trainId);

		// Assert
		assertNotNull(retrievedTrain);
		assertEquals(train1.getId(), retrievedTrain.getId());
		assertEquals(train1.getTrainName(), retrievedTrain.getTrainName());
		assertEquals(train1.getSource(), retrievedTrain.getSource());
		assertEquals(train1.getDestination(), retrievedTrain.getDestination());
		verify(trainRepository, times(1)).findById(trainId);
	}

	@Test
	@DisplayName("Should throw exception when train not found")
	public void testGetTrainNotFound() {
		// Arrange
		int trainId = 999;
		when(trainRepository.findById(trainId)).thenReturn(Optional.empty());

		// Act & Assert
		assertThrows(Exception.class, () -> trainServiceImpl.getTrain(trainId));
		verify(trainRepository, times(1)).findById(trainId);
	}

	@Test
	@DisplayName("Should retrieve all trains")
	public void testGetAllTrains() {
		// Arrange
		when(trainRepository.findAll()).thenReturn(trainList);

		// Act
		List<Train> retrievedTrains = trainServiceImpl.getAllTrains();

		// Assert
		assertNotNull(retrievedTrains);
		assertEquals(3, retrievedTrains.size());
		assertEquals(train1.getId(), retrievedTrains.get(0).getId());
		assertEquals(train2.getId(), retrievedTrains.get(1).getId());
		assertEquals(train3.getId(), retrievedTrains.get(2).getId());
		verify(trainRepository, times(1)).findAll();
	}

	@Test
	@DisplayName("Should retrieve empty list when no trains exist")
	public void testGetAllTrainsEmpty() {
		// Arrange
		when(trainRepository.findAll()).thenReturn(new ArrayList<>());

		// Act
		List<Train> retrievedTrains = trainServiceImpl.getAllTrains();

		// Assert
		assertNotNull(retrievedTrains);
		assertTrue(retrievedTrains.isEmpty());
		assertEquals(0, retrievedTrains.size());
		verify(trainRepository, times(1)).findAll();
	}

	@Test
	@DisplayName("Should retrieve all trains and verify correct content")
	public void testGetAllTrainsContent() {
		// Arrange
		when(trainRepository.findAll()).thenReturn(trainList);

		// Act
		List<Train> retrievedTrains = trainServiceImpl.getAllTrains();

		// Assert
		assertTrue(retrievedTrains.contains(train1));
		assertTrue(retrievedTrains.contains(train2));
		assertTrue(retrievedTrains.contains(train3));
	}

	@Test
	@DisplayName("Should add train with all fields")
	public void testAddTrainWithAllFields() {
		// Arrange
		Train newTrain = new Train();
		newTrain.setId(4);
		newTrain.setTrainNumber(99999);
		newTrain.setTrainName("Test Train");
		newTrain.setSource("TestSource");
		newTrain.setDestination("TestDest");
		newTrain.setTime(LocalTime.of(8, 0));

		when(trainRepository.save(newTrain)).thenReturn(newTrain);

		// Act
		trainServiceImpl.addTrain(newTrain);

		// Assert
		verify(trainRepository, times(1)).save(newTrain);
	}

	@Test
	@DisplayName("Should handle train with null values")
	public void testAddTrainWithNullValues() {
		// Arrange
		Train nullTrain = new Train();
		when(trainRepository.save(nullTrain)).thenReturn(nullTrain);

		// Act
		trainServiceImpl.addTrain(nullTrain);

		// Assert
		verify(trainRepository, times(1)).save(nullTrain);
	}
}
