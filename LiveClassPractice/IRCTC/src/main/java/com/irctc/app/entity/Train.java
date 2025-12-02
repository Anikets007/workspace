package com.irctc.app.entity;

import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Train {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int trainNumber;
	private String trainName;
	private String source;
	private String destination;
	private LocalTime time;

	@Override
	public String toString() {
		return "Train [id=" + id + ", trainNumber=" + trainNumber + ", trainName=" + trainName + ", source=" + source
				+ ", destination=" + destination + ", time=" + time + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTrainNumber() {
		return trainNumber;
	}

	public void setTrainNumber(int trainNumber) {
		this.trainNumber = trainNumber;
	}

	public String getTrainName() {
		return trainName;
	}

	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}

}
