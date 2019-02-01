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
import com.qa.util.JSONUtil;


@Default
@Transactional(SUPPORTS)
public class ClassroomImpl implements ClassroomTrainerRepository{
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
	public String createClassroomTrainer(String trainer) {
		Classroom aTrainer = util.getObjectForJSON(trainer, Classroom.class);
		em.persist(aTrainer);
		return "{\"message\"} ";
	}

	@Override
	public String deleteClassroomTrainer(Long id) {
		Classroom classroomInDB = em.find(Classroom.class, id);
		if(classroomInDB != null) {
			em.remove(classroomInDB);
		}		
		return " ";
	}

	@Override
	@Transactional(REQUIRED)
	public String updateClassrooomTrainer(Long id, String trainer) {
		Classroom accountInDB = em.find(Classroom.class, id);
		if(accountInDB != null) {
			em.remove(accountInDB);	
			Classroom anAccount = util.getObjectForJSON(trainer, Classroom.class);
			em.persist(anAccount);
	}
	return " ";
	}

	
}
