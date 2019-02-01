package com.qa.persistence.repository;

import java.util.HashMap;
import java.util.Map;

import javax.enterprise.inject.Alternative;

import com.qa.persistence.domain.Classroom;
import com.qa.util.JSONUtil;



@Alternative
public class ClassroomMapRepository implements ClassroomTrainerRepository{

	public Map<Long, Classroom> classrooms = new HashMap<>();
	JSONUtil util = new JSONUtil();
	
	public String getAll() {
		String result = " ";
		for (int i = 0; i < classrooms.size(); i++) {

			result += util.getJSONForObject(classrooms.get(i));
		}
		return result;	}

//	public String getAClassroomTrainer() {
//
//		return null;
//	}

	public String createClassroomTrainer(String trainer) {
		Classroom AClassroomTrainer = util.getObjectForJSON(trainer, Classroom.class);
		classrooms.put((long) classrooms.size(), AClassroomTrainer);
		return "Classroom with trainer created";

	}

	public String deleteClassroomTrainer(Long id) {
		boolean countExists = classrooms.containsKey(id);
		if (countExists) {
			classrooms.remove(id);
		}
		return "Classroom has been deleted successfully";		
	}

	public String updateClassrooomTrainer(Long id, String trainer) {
		Classroom anAccount = util.getObjectForJSON(trainer, Classroom.class);
		classrooms.replace(id, anAccount);
		return "account updated";
	}

	
}
