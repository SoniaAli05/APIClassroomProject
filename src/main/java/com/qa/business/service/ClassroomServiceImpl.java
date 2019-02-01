package com.qa.business.service;

import javax.inject.Inject;

import com.qa.persistence.domain.Classroom;
import com.qa.persistence.repository.ClassroomTrainerRepository;
import com.qa.util.JSONUtil;


public class ClassroomServiceImpl implements ClassroomService{
	JSONUtil util = new JSONUtil();

	@Inject 
	private ClassroomTrainerRepository repo;

	@Override
	public String getAll() {
		return repo.getAll();
	}

	@Override
	public String createClassroomTrainer(String trainer) {
		Classroom aTrainer = util.getObjectForJSON(trainer, Classroom.class);
		if(aTrainer.getTrainerName() == "Charlotte Hoy") {
			return "{\"message\": \"Account Number: '" + aTrainer.getTrainerName() + "' is Blocked!\"}";
		}
		return repo.createClassroomTrainer(trainer);
	}

	@Override
	public String deleteClassroomTrainer(Integer id) {
		return repo.deleteClassroomTrainer(id);
	}

	@Override
	public String updateClassrooomTrainer(Integer id, String trainer) {
		return repo.updateClassrooomTrainer(id, trainer);
	}
		
}
