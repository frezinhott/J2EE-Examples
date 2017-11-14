package org.chase.REST_Messenger.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("/injectdemo") 
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.TEXT_PLAIN)
public class InjectDemoResource {

	/**
	 * http://localhost:8080/REST-Messenger/webapi/injectdemo/annotations
	 * 
	 * @MatrixParam are separated by a ";"
	 * http://localhost:8080/REST-Messenger/webapi/messages;param=variable
	 * 
	 * @HeaderParam - inject the Header variable "headerParams" into the header method variable
	 * @CookieParam - inject the Cookie name into the value method variable
	 * 
	 * @return returns the matrix parameter
	 */
	@GET
	@Path("annotations")
	public String getParamsUsingAnnotations(@MatrixParam("param") String matrixParam,
											@HeaderParam("headerParam") String header,
											@CookieParam("name") String cookie){
		return "Matrix Param: " + matrixParam + ", Header Param: " +  header + ", Cookie Param: " + cookie;
		
	}
	
	/**
	 * http://localhost:8080/REST-Messenger/webapi/context
	 * 
	 * UriInfo contains URI information about the resource being called
	 * HttpHeaders contains header information about the resource being called
	 */
	@GET
	@Path("context")
	public String getParamsUsingContext(@Context UriInfo uriInfo, @Context HttpHeaders headers){
		// Get the URI path
		String path = uriInfo.getAbsolutePath().toString();
		String cookies = headers.getCookies().toString();
		return "Path: " + path + ", Cookies: " + cookies;
	}
	
	
}
