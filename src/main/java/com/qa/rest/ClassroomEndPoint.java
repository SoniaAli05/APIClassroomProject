package com.qa.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.business.service.ClassroomService;


@Path("/classroom")
public class ClassroomEndPoint {

	@Inject
	private ClassroomService service;

	@Path("/getAllTrainers")
	// method that i want to activate
	@GET
	@Produces({ "application/json" })
	public String getAll() {
		return service.getAll();
	}

	@Path("/createTrainer")
	@POST
	@Produces({ "application/json" })
	public String createClassroomTrainer(String trainer) {
		return service.createClassroomTrainer(trainer);
	}

	@Path("/deleteTrainer/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteClassroomTrainer(@PathParam("id") Integer id) {
		return service.deleteClassroomTrainer(id);
	}
	
	@Path("/updateTrainer")
	@PUT
	@Produces({ "application/json" })
	public String updateTrainee(@PathParam("id") Integer id, String trainer) {
		return service.updateClassrooomTrainer(id, trainer);
	}

	public void setService(ClassroomService service) {
		this.service = service;
	}
}
