package com.services;



import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.managers.Manager;


@Path("/ManagerService")
public class ManagerService {

	 @GET
	   @Path("/manager")
	   @Produces(MediaType.APPLICATION_JSON)
	   public Manager getUsers(){
		 Manager m = new Manager(1, "aakash");
	      return m;
	   }	
	
	
}
