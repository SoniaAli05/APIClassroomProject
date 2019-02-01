package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.qa.persistence.domain.Classroom;
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
		Query query = em.createQuery("SELECT a FROM Trainee a");
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
	public String deleteTrainee(Integer id) {
		Query query = em.createQuery("DELETE a FROM Trainee a WHERE a.id = "+ id, Trainee.class);
		return (util.getJSONForObject(query.getResultList()));
	}

	@Override
	@Transactional(REQUIRED)
	public String updateTrainee(Integer id, String trainee) {
		Trainee aTrainee = util.getObjectForJSON(trainee, Trainee.class);
		Query query = em.createQuery("DELETE a FROM Classroom a WHERE a.id = "+ id, Trainee.class);
		em.persist(aTrainee);
		return "{\"message: updated\"} ";


}
}
