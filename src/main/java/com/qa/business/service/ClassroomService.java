package com.qa.business.service;

public interface ClassroomService {
	String getAll();
//	String getAClassroomTrainer();
	String createClassroomTrainer(String trainer);
	String deleteClassroomTrainer(Integer id);
	String updateClassrooomTrainer(Integer id, String trainer);
}
