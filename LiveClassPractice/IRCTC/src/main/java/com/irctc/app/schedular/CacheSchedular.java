package com.irctc.app.schedular;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.irctc.app.cache.TrainCache;

@Component
@EnableScheduling
public class CacheSchedular {

	@Autowired
	TrainCache cache;
	
	@Scheduled(fixedDelay = 20000L)
	public void execute() {
		System.out.println("Executing cache clear every 20 seconds");
	cache.clear();
	
	System.out.println("Fetching all data into cache...");
	
	cache.fetchAllTrainsOnStartUp();
	}
}
