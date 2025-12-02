package com.irctc.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.irctc.app.entity.Train;

public interface TrainRepository extends JpaRepository<Train, Integer>{

}
