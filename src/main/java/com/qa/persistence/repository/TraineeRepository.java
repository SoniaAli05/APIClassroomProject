package com.qa.persistence.repository;

public interface TraineeRepository {
	
	String getAll();
	String createTrainee(String trainee);
	String deleteTrainee(Long id);
	String updateTrainee(Long id, String trainee);

	
}
