package com.qa.persistence.repository;

public interface ClassroomTrainerRepository {

	String getAll();
//	String getAClassroomTrainer();
	String createClassroomTrainer(String trainer);
	String deleteClassroomTrainer(Integer id);
	String updateClassrooomTrainer(Integer id, String trainer);

}
