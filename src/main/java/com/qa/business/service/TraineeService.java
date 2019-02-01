package com.qa.business.service;

public interface TraineeService {
	String getAll();
	String createTrainee(String trainee);
	String deleteTrainee(Integer id);
	String updateTrainee(Integer id, String trainee);
}
