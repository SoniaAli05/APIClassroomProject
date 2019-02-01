package com.qa.business.service;

public interface TraineeService {
	String getAll();
	String createTrainee(String trainee);
	String deleteTrainee(Long id);
	String updateTrainee(Long id, String trainee);
}
