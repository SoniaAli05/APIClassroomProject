package com.qa.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.business.service.TraineeService;


@Path("/trainee")

public class TraineeEndPoint {
	@Inject
	private TraineeService service;

	@Path("/getAllTrainees")
	// method that i want to activate
	@GET
	@Produces({ "application/json" })
	public String getAll() {
		return service.getAll();
	}

	@Path("/createTrainee")
	@POST
	@Produces({ "application/json" })
	public String createTrainee(String trainee) {
		return service.createTrainee(trainee);
	}

	@Path("/deleteATrainee/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteTrainee(@PathParam("id") Integer id) {
		return service.deleteTrainee(id);
	}
	
	@Path("/updateTrainee")
	@PUT
	@Produces({ "application/json" })
	public String updateTrainee(@PathParam("id") Integer id, String trainee) {
		return service.updateTrainee(id, trainee);
	}

	public void setService(TraineeService service) {
		this.service = service;
	}
}
