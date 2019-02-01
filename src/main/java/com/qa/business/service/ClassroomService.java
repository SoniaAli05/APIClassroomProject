package com.qa.business.service;

public interface ClassroomService {
	String getAll();
//	String getAClassroomTrainer();
	String createClassroomTrainer(String trainer);
	String deleteClassroomTrainer(Long id);
	String updateClassrooomTrainer(Long id, String trainer);
}
