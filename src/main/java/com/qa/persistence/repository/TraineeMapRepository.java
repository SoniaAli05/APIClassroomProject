package com.qa.persistence.repository;

import java.util.HashMap;
import java.util.Map;

import com.qa.persistence.domain.Trainee;
import com.qa.util.JSONUtil;

public class TraineeMapRepository implements TraineeRepository{


	public Map<Long, Trainee> trainees = new HashMap<>();
	JSONUtil util = new JSONUtil();
	@Override
	public String getAll() {
		String result = " ";
		for (int i = 0; i < trainees.size(); i++) {

			result += util.getJSONForObject(trainees.get(i));
		}
		return result;	}

	@Override
	public String createTrainee(String trainee) {
		Trainee ATrainer = util.getObjectForJSON(trainee, Trainee.class);
		trainees.put((long) trainees.size(), ATrainer);
		return "A new Trainee has been created";
	}

	@Override
	public String deleteTrainee(Long id) {
		boolean countExists = trainees.containsKey(id);
		if (countExists) {
			trainees.remove(id);
		}
		return "Classroom has been deleted successfully";
	}

	@Override
	public String updateTrainee(Long id, String trainee) {
		Trainee aTrainee = util.getObjectForJSON(trainee, Trainee.class);
		trainees.replace(id, aTrainee);
		return "account updated";		
	}

}
