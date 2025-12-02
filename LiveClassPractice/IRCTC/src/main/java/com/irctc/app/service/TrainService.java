package com.irctc.app.service;

import java.util.List;

import com.irctc.app.entity.Train;

public interface TrainService {

	public void addTrain(Train train);

	public void addTrains(List<Train> trains);

	public void deleteTrain(int id);

	public Train getTrain(int id);

	public List<Train> getAllTrains();
}
