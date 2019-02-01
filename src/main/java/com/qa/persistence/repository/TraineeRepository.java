package com.qa.persistence.repository;

public interface TraineeRepository {
	
	String getAll();
	String createTrainee(String trainee);
	String deleteTrainee(Integer id);
	String updateTrainee(Integer id, String trainee);

	
}
