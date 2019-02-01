package com.qa.business.service;

import javax.inject.Inject;

import com.qa.persistence.domain.Trainee;
import com.qa.persistence.repository.TraineeRepository;
import com.qa.util.JSONUtil;

public class TraineeServiceImpl implements TraineeService{
	JSONUtil util = new JSONUtil();

	@Inject 
	private TraineeRepository repo;

	@Override
	public String getAll() {
		return repo.getAll();
	}

	@Override
	public String createTrainee(String trainee) {
		Trainee aTrainee = util.getObjectForJSON(trainee, Trainee.class);
		if(aTrainee.getTraineeName() == "Charlotte Hoy") {
			return "{\"message\": \"Account Number: '" + aTrainee.getTraineeName() + "' is Blocked!\"}";
		}
		return repo.createTrainee(trainee);
	}

	@Override
	public String deleteTrainee(Long id) {
		return repo.deleteTrainee(id);
	}

	@Override
	public String updateTrainee(Long id, String trainee) {
		return repo.updateTrainee(id, trainee);
	}

}
