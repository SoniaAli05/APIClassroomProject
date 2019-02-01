package com.qa.business.service;

import javax.inject.Inject;

import com.qa.persistence.domain.Trainee;
import com.qa.persistence.repository.TraineeRepository;
import com.qa.util.JSONUtil;

public class TraineeServiceImpl implements TraineeService{
	JSONUtil util = new JSONUtil();

	@Inject 
	private TraineeRepository repo;

	public String getAll() {
		return repo.getAll();
	}

	public String createTrainee(String trainee) {
		Trainee aTrainee = util.getObjectForJSON(trainee, Trainee.class);
		if(aTrainee.getTraineeName() == "Charlotte Hoy") {
			return "{\"message\": \"Account Number: '" + aTrainee.getTraineeName() + "' is Blocked!\"}";
		}
		return repo.createTrainee(trainee);
	}

	public String deleteTrainee(Integer id) {
		return repo.deleteTrainee(id);
	}

	public String updateTrainee(Integer id, String trainee) {
		return repo.updateTrainee(id, trainee);
	}

}
