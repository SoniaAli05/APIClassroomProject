package com.qa.persistence.domain;

import java.util.Collection;
import java.util.LinkedHashSet;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Classroom {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Integer classid;
	private String trainerName;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "id", cascade = CascadeType.ALL)
	private Collection<Trainee> trainees = new LinkedHashSet<Trainee>();
	

	public Classroom() {

	}

	public Classroom(Integer classid, String trainerName) {
		this.trainerName = trainerName;
		this.classid = classid;
	}

	public Integer getId() {
		return classid;
	}

	public void setId(Integer id) {
		this.classid = id;
	}

	public String getTrainerName() {
		return trainerName;
	}

	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}

}
