package com.irctc.app.entity;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

@DisplayName("Train Entity Unit Tests")
class TrainTest {

	private Train train;

	@BeforeEach
	void setUp() {
		train = new Train();
	}

	@Test
	@DisplayName("Should set and get train ID")
	void testSetAndGetId() {
		// Arrange
		int expectedId = 1;

		// Act
		train.setId(expectedId);

		// Assert
		assertEquals(expectedId, train.getId());
	}

	@Test
	@DisplayName("Should set and get train number")
	void testSetAndGetTrainNumber() {
		// Arrange
		int expectedNumber = 12345;

		// Act
		train.setTrainNumber(expectedNumber);

		// Assert
		assertEquals(expectedNumber, train.getTrainNumber());
	}

	@Test
	@DisplayName("Should set and get train name")
	void testSetAndGetTrainName() {
		// Arrange
		String expectedName = "Express";

		// Act
		train.setTrainName(expectedName);

		// Assert
		assertEquals(expectedName, train.getTrainName());
	}

	@Test
	@DisplayName("Should set and get source")
	void testSetAndGetSource() {
		// Arrange
		String expectedSource = "Delhi";

		// Act
		train.setSource(expectedSource);

		// Assert
		assertEquals(expectedSource, train.getSource());
	}

	@Test
	@DisplayName("Should set and get destination")
	void testSetAndGetDestination() {
		// Arrange
		String expectedDestination = "Mumbai";

		// Act
		train.setDestination(expectedDestination);

		// Assert
		assertEquals(expectedDestination, train.getDestination());
	}

	@Test
	@DisplayName("Should set and get departure time")
	void testSetAndGetTime() {
		// Arrange
		LocalTime expectedTime = LocalTime.of(10, 30);

		// Act
		train.setTime(expectedTime);

		// Assert
		assertEquals(expectedTime, train.getTime());
	}

	@Test
	@DisplayName("Should initialize train with all fields")
	void testTrainWithAllFields() {
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

	@Test
	@DisplayName("Should generate correct toString representation")
	void testTrainToString() {
		// Arrange
		train.setId(1);
		train.setTrainNumber(12345);
		train.setTrainName("Express");
		train.setSource("Delhi");
		train.setDestination("Mumbai");
		train.setTime(LocalTime.of(10, 30));

		// Act
		String result = train.toString();

		// Assert
		assertNotNull(result);
		assertTrue(result.contains("id=1"));
		assertTrue(result.contains("trainNumber=12345"));
		assertTrue(result.contains("trainName=Express"));
		assertTrue(result.contains("source=Delhi"));
		assertTrue(result.contains("destination=Mumbai"));
		assertTrue(result.contains("10:30"));
	}

	@Test
	@DisplayName("Should handle train with null train name")
	void testTrainWithNullTrainName() {
		// Act
		train.setTrainName(null);

		// Assert
		assertNull(train.getTrainName());
	}

	@Test
	@DisplayName("Should handle train with null source")
	void testTrainWithNullSource() {
		// Act
		train.setSource(null);

		// Assert
		assertNull(train.getSource());
	}

	@Test
	@DisplayName("Should handle train with null destination")
	void testTrainWithNullDestination() {
		// Act
		train.setDestination(null);

		// Assert
		assertNull(train.getDestination());
	}

	@Test
	@DisplayName("Should handle train with null time")
	void testTrainWithNullTime() {
		// Act
		train.setTime(null);

		// Assert
		assertNull(train.getTime());
	}

	@Test
	@DisplayName("Should handle train with zero ID")
	void testTrainWithZeroId() {
		// Act
		train.setId(0);

		// Assert
		assertEquals(0, train.getId());
	}

	@Test
	@DisplayName("Should handle train with negative train number")
	void testTrainWithNegativeNumber() {
		// Act
		train.setTrainNumber(-1);

		// Assert
		assertEquals(-1, train.getTrainNumber());
	}

	@Test
	@DisplayName("Should handle train with different times")
	void testTrainWithDifferentTimes() {
		// Act
		train.setTime(LocalTime.of(0, 0));
		assertEquals(LocalTime.of(0, 0), train.getTime());

		train.setTime(LocalTime.of(23, 59));
		assertEquals(LocalTime.of(23, 59), train.getTime());

		train.setTime(LocalTime.of(12, 30));
		assertEquals(LocalTime.of(12, 30), train.getTime());

		// Assert - All times are correctly stored
		assertTrue(true);
	}

	@Test
	@DisplayName("Should allow modification of all fields after initialization")
	void testTrainModification() {
		// Arrange - Initial values
		train.setId(1);
		train.setTrainNumber(12345);
		train.setTrainName("Express");
		train.setSource("Delhi");
		train.setDestination("Mumbai");
		train.setTime(LocalTime.of(10, 30));

		// Act - Modify values
		train.setId(2);
		train.setTrainNumber(54321);
		train.setTrainName("Local");
		train.setSource("Mumbai");
		train.setDestination("Pune");
		train.setTime(LocalTime.of(14, 45));

		// Assert - New values are set
		assertEquals(2, train.getId());
		assertEquals(54321, train.getTrainNumber());
		assertEquals("Local", train.getTrainName());
		assertEquals("Mumbai", train.getSource());
		assertEquals("Pune", train.getDestination());
		assertEquals(LocalTime.of(14, 45), train.getTime());
	}

	@Test
	@DisplayName("Should handle train with empty string values")
	void testTrainWithEmptyStrings() {
		// Act
		train.setTrainName("");
		train.setSource("");
		train.setDestination("");

		// Assert
		assertEquals("", train.getTrainName());
		assertEquals("", train.getSource());
		assertEquals("", train.getDestination());
	}

	@Test
	@DisplayName("Should handle train with special characters in names")
	void testTrainWithSpecialCharacters() {
		// Act
		train.setTrainName("Express @ 2024");
		train.setSource("Delhi (North)");
		train.setDestination("Mumbai-Central");

		// Assert
		assertEquals("Express @ 2024", train.getTrainName());
		assertEquals("Delhi (North)", train.getSource());
		assertEquals("Mumbai-Central", train.getDestination());
	}

	@Test
	@DisplayName("Should handle large train numbers")
	void testTrainWithLargeNumber() {
		// Act
		int largeNumber = Integer.MAX_VALUE;
		train.setTrainNumber(largeNumber);

		// Assert
		assertEquals(largeNumber, train.getTrainNumber());
	}
}
