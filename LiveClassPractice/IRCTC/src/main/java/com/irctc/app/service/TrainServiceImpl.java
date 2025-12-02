package com.irctc.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irctc.app.entity.Train;
import com.irctc.app.repository.TrainRepository;

@Service
public class TrainServiceImpl implements TrainService {

	@Autowired
	TrainRepository trainRepository;

	@Override
	public void addTrain(Train train) {

		trainRepository.save(train);
	}

	@Override
	public void addTrains(List<Train> trains) {
		trainRepository.saveAll(trains);
	}

	@Override
	public void deleteTrain(int id) {
		trainRepository.deleteById(id);
	}

	@Override
	public Train getTrain(int id) {
		return trainRepository.findById(id).get();
	}

	@Override
	public List<Train> getAllTrains() {
		return trainRepository.findAll();
	}

}
