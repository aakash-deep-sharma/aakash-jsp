package com.services;



import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBElement;

import com.managers.Manager;


@Path("/ManagerService")
public class ManagerService {

		@GET
	    @Path("/manager")
	    @Produces(MediaType.APPLICATION_XML)
	    public Manager getUser()
		{
		Manager m = new Manager(1, "aakash");
	    return m;
		}
		
		
		
		@GET
		@Path("/managers/{managerid}/{mname}")
		@Produces(MediaType.APPLICATION_XML)
		public Manager getUser(@PathParam("managerid") int mid,
							   @PathParam("mname") String mname)
		{

				Manager m = new Manager();
				m.setId(mid);
				m.setName(mname);
				return m;
		}
		
		
		
		@PUT
		@Path("/create")
		@Produces(MediaType.APPLICATION_XML)
		public Manager Create(JAXBElement<Manager> manager)
		{
			Manager m = manager.getValue();
			System.out.println(m);
			
			return m;
		}
		
		
		@PUT
		@Path("/managers")
		@Produces(MediaType.APPLICATION_XML)
		@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
		public Manager createUser(@FormParam("id") int id,
								  @FormParam("name") String name)
		{
		    Manager m = new Manager();
		    m.setId(id);
		    m.setName(name);
		    System.out.println(id +" "+name);
		    return m; 
		}
		
		
		
		
		
	
	
}
