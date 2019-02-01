package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.qa.persistence.domain.Trainee;
import com.qa.util.JSONUtil;

@Default
@Transactional(SUPPORTS)
public class TraineeImpl implements TraineeRepository{

	@PersistenceContext(unitName = "primary")
	private EntityManager em;
	
	@Inject
	private JSONUtil util;

	@Override
	@Transactional(REQUIRED)
	public String getAll() {
		Query query = em.createQuery("SELECT a FROM Account a");
		return (util.getJSONForObject(query.getResultList()));
	}

	@Override
	@Transactional(REQUIRED)
	public String createTrainee(String trainee) {
		Trainee aTrainer = util.getObjectForJSON(trainee, Trainee.class);
		em.persist(aTrainer);
		return "{\"message\"} ";		
	}

	@Override
	@Transactional(REQUIRED)
	public String deleteTrainee(Long id) {
		Trainee classroomInDB = em.find(Trainee.class, id);
		if(classroomInDB != null) {
			em.remove(classroomInDB);
		}		
		return " ";
	}

	@Override
	@Transactional(REQUIRED)
	public String updateTrainee(Long id, String trainee) {
		Trainee accountInDB = em.find(Trainee.class, id);
		if(accountInDB != null) {
			em.remove(accountInDB);	
			Trainee anAccount = util.getObjectForJSON(trainee, Trainee.class);
			em.persist(anAccount);
	}
	return " ";
	}
	

}
