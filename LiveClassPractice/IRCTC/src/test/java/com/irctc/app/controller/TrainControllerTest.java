package com.irctc.app.controller;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.irctc.app.entity.Train;
import com.irctc.app.service.TrainService;

@WebMvcTest(TrainController.class)
@DisplayName("TrainController Unit Tests")
class TrainControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockitoBean
	private TrainService trainService;

	@Autowired
	private ObjectMapper objectMapper;

	private Train train1;
	private Train train2;
	private List<Train> trainList;

	@BeforeEach
	void setUp() {
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
	@DisplayName("POST /addTrain - Should add a single train and return 201 CREATED")
	void testAddTrain() throws Exception {
		// Arrange
		doNothing().when(trainService).addTrain(any());

		// Act & Assert
		mockMvc.perform(post("/addTrain")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(train1)))
				.andExpect(status().isCreated())
				.andExpect(content().string(containsString("Train added successfully")));

		verify(trainService, times(1)).addTrain(any());
	}

	@Test
	@DisplayName("POST /addTrain - Should add train with all fields")
	void testAddTrainWithAllFields() throws Exception {
		// Arrange
		Train newTrain = new Train();
		newTrain.setId(3);
		newTrain.setTrainNumber(99999);
		newTrain.setTrainName("Test Train");
		newTrain.setSource("TestSource");
		newTrain.setDestination("TestDest");
		newTrain.setTime(LocalTime.of(8, 0));

		doNothing().when(trainService).addTrain(any());

		// Act & Assert
		mockMvc.perform(post("/addTrain")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(newTrain)))
				.andExpect(status().isCreated())
				.andExpect(content().string(containsString("Train added successfully")));

		verify(trainService, times(1)).addTrain(any());
	}

	@Test
	@DisplayName("POST /addTrains - Should add multiple trains and return 201 CREATED")
	void testAddTrains() throws Exception {
		// Arrange
		doNothing().when(trainService).addTrains(any());

		// Act & Assert
		mockMvc.perform(post("/addTrains")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(trainList)))
				.andExpect(status().isCreated())
				.andExpect(content().string(containsString("All trais added")));

		verify(trainService, times(1)).addTrains(any());
	}

	@Test
	@DisplayName("POST /addTrains - Should handle empty train list")
	void testAddEmptyTrainsList() throws Exception {
		// Arrange
		List<Train> emptyList = new ArrayList<>();
		doNothing().when(trainService).addTrains(emptyList);

		// Act & Assert
		mockMvc.perform(post("/addTrains")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(emptyList)))
				.andExpect(status().isCreated());

		verify(trainService, times(1)).addTrains(emptyList);
	}

	@Test
	@DisplayName("DELETE /deleteTrain/{id} - Should delete a train by ID and return 202 ACCEPTED")
	void testDeleteTrain() throws Exception {
		// Arrange
		int trainId = 1;
		doNothing().when(trainService).deleteTrain(trainId);

		// Act & Assert
		mockMvc.perform(delete("/deleteTrain/{id}", trainId))
				.andExpect(status().isAccepted())
				.andExpect(content().string(containsString("deleted succesfully")));

		verify(trainService, times(1)).deleteTrain(trainId);
	}

	@Test
	@DisplayName("DELETE /deleteTrain/{id} - Should delete multiple trains")
	void testDeleteMultipleTrains() throws Exception {
		// Act & Assert
		mockMvc.perform(delete("/deleteTrain/{id}", 1))
				.andExpect(status().isAccepted())
				.andExpect(content().string(containsString("deleted succesfully")));

		mockMvc.perform(delete("/deleteTrain/{id}", 2))
				.andExpect(status().isAccepted());

		verify(trainService, times(1)).deleteTrain(1);
		verify(trainService, times(1)).deleteTrain(2);
	}

	@Test
	@DisplayName("GET /train/{id} - Should retrieve a train by ID and return 200 OK")
	void testGetTrain() throws Exception {
		// Arrange
		int trainId = 1;
		when(trainService.getTrain(trainId)).thenReturn(train1);

		// Act & Assert
		mockMvc.perform(get("/train/{id}", trainId))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.id", is(train1.getId())))
				.andExpect(jsonPath("$.trainNumber", is(train1.getTrainNumber())))
				.andExpect(jsonPath("$.trainName", is(train1.getTrainName())))
				.andExpect(jsonPath("$.source", is(train1.getSource())))
				.andExpect(jsonPath("$.destination", is(train1.getDestination())));

		verify(trainService, times(1)).getTrain(trainId);
	}

	@Test
	@DisplayName("GET /train/{id} - Should retrieve different trains")
	void testGetDifferentTrains() throws Exception {
		// Arrange
		when(trainService.getTrain(1)).thenReturn(train1);
		when(trainService.getTrain(2)).thenReturn(train2);

		// Act & Assert
		mockMvc.perform(get("/train/{id}", 1))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.trainName", is("Express")));

		mockMvc.perform(get("/train/{id}", 2))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.trainName", is("Local")));

		verify(trainService, times(1)).getTrain(1);
		verify(trainService, times(1)).getTrain(2);
	}

	@Test
	@DisplayName("GET /trains - Should retrieve all trains and return 200 OK")
	void testGetAllTrains() throws Exception {
		// Arrange
		when(trainService.getAllTrains()).thenReturn(trainList);

		// Act & Assert
		mockMvc.perform(get("/trains"))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$", hasSize(2)))
				.andExpect(jsonPath("$[0].id", is(train1.getId())))
				.andExpect(jsonPath("$[0].trainName", is(train1.getTrainName())))
				.andExpect(jsonPath("$[1].id", is(train2.getId())))
				.andExpect(jsonPath("$[1].trainName", is(train2.getTrainName())));

		verify(trainService, times(1)).getAllTrains();
	}

	@Test
	@DisplayName("GET /trains - Should handle empty train list")
	void testGetAllTrainsEmpty() throws Exception {
		// Arrange
		when(trainService.getAllTrains()).thenReturn(new ArrayList<>());

		// Act & Assert
		mockMvc.perform(get("/trains"))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$", hasSize(0)));

		verify(trainService, times(1)).getAllTrains();
	}

	@Test
	@DisplayName("GET /trains - Should verify all train fields")
	void testGetAllTrainsFullContent() throws Exception {
		// Arrange
		when(trainService.getAllTrains()).thenReturn(trainList);

		// Act & Assert
		mockMvc.perform(get("/trains"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$[0].source", is(train1.getSource())))
				.andExpect(jsonPath("$[0].destination", is(train1.getDestination())))
				.andExpect(jsonPath("$[1].source", is(train2.getSource())))
				.andExpect(jsonPath("$[1].destination", is(train2.getDestination())));

		verify(trainService, times(1)).getAllTrains();
	}

	@Test
	@DisplayName("POST /addTrain - Should handle train with minimum fields")
	void testAddTrainWithMinimumFields() throws Exception {
		// Arrange
		Train minimalTrain = new Train();
		minimalTrain.setId(10);
		doNothing().when(trainService).addTrain(any());

		// Act & Assert
		mockMvc.perform(post("/addTrain")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(minimalTrain)))
				.andExpect(status().isCreated());

		verify(trainService, times(1)).addTrain(any());
	}
}
