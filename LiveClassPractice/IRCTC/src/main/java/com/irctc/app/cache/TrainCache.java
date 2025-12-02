package com.irctc.app.cache;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.irctc.app.entity.Train;
import com.irctc.app.repository.TrainRepository;


@Component
public class TrainCache {

	Map<Integer, Train> map = new ConcurrentHashMap<>();

	@Autowired
	TrainRepository trainRepo;

	public void fetchAllTrainsOnStartUp() {
		System.out.println("Fetching all trains ");
		List<Train> trains = trainRepo.findAll();

		for (Train train : trains) {
			map.put(train.getId(), train);
		}

		System.out.println("All Train data loaded");
	}

	public boolean check(int id) {
		System.out.println("Checking data in cache");

		return map.containsKey(id);
	}

	public void storeTrain(Train train) {
		System.out.println("Storing trains into cache");
		map.put(train.getId(), train);

		System.out.println("Data stored into cache");
	}

	public Train getTrain(int id) {
		System.out.println("Getting train data from cache");
		return map.get(id);
	}

	public void clear() {
		System.out.println("Clearing cache...");
		map.clear();
	}
}
