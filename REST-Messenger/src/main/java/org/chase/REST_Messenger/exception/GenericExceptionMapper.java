package org.chase.REST_Messenger.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.chase.REST_Messenger.model.ErrorMessage;

/**
 * Catch all exceptions
 * 
 * @Provier registers the GenericExceptionMapper with JAX-RS
 * @author Trevor Chase
 *
 */
@Provider
public class GenericExceptionMapper implements ExceptionMapper<Throwable> {
	
	@Override
	public Response toResponse(Throwable ex) {
		ErrorMessage errorMessage = new ErrorMessage(ex.getMessage(), 500, "http://link.to.documentation");
		// Return a Response with the JSON error message and a status not found code
		return Response.status(Status.INTERNAL_SERVER_ERROR)
				.entity(errorMessage)
				.build();
	}	

}
