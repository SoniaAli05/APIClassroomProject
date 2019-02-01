package com.qa.persistence.repository;

public interface ClassroomTrainerRepository {

	String getAll();
//	String getAClassroomTrainer();
	String createClassroomTrainer(String trainer);
	String deleteClassroomTrainer(Long id);
	String updateClassrooomTrainer(Long id, String trainer);

}
