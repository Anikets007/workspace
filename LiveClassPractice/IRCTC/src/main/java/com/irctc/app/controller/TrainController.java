package com.irctc.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.irctc.app.entity.Train;
import com.irctc.app.service.TrainService;

@RestController
public class TrainController {

	@Autowired
	TrainService trainService;

	@PostMapping("addTrain")
	public ResponseEntity<String> addTrain(@RequestBody Train train) {
		trainService.addTrain(train);
		return new ResponseEntity<>("Train added successfully", HttpStatus.CREATED);
	}

	@PostMapping("addTrains")
	public ResponseEntity<String> addTrains(@RequestBody List<Train> trains) {
		trainService.addTrains(trains);
		return new ResponseEntity<>("All trais added", HttpStatus.CREATED);
	}

	@DeleteMapping("deleteTrain/{id}")
	public ResponseEntity<String> deleteTrain(@PathVariable("id") int id) {
		trainService.deleteTrain(id);
		return new ResponseEntity<>("Train with id: " + id + " deleted succesfully", HttpStatus.ACCEPTED);
	}

	@GetMapping("train/{id}")
	public ResponseEntity<Train> getTrain(@PathVariable("id") int id) {
		return new ResponseEntity<Train>(trainService.getTrain(id), HttpStatus.OK);
	}

	@GetMapping("trains")
	public ResponseEntity<List<Train>> getAllTrains() {
		return new ResponseEntity<List<Train>>(trainService.getAllTrains(), HttpStatus.OK);
	}
}
