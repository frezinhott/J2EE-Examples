package org.chase.rest_messenger_adv.resources;

import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


/**
 * This is a test of the singleton resource.  This resource will stay alive until the tomcat server
 * is shut down.  All variables are held in memory until then.
 * 
 * @Singleton - Makes this resource a singleton.
 * 
 * @author Trevor Chase
 *
 */
@Path("singleton")
@Singleton
public class SingletonResource {
	
	private int count;

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String testResource(){
		count++;
		return "This method was called " + count + " times";
	}
	
}
