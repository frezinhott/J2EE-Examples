package org.chase.REST_Messenger.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.chase.REST_Messenger.model.ErrorMessage;

/**
 * @Provier registers the DataNotFoundExceptionMapper with JAX-RS
 * @author Trevor Chase
 *
 */

@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException>{

	@Override
	public Response toResponse(DataNotFoundException ex) {
		ErrorMessage errorMessage = new ErrorMessage(ex.getMessage(), 404, "http://link.to.documentation");
		// Return a Response with the JSON error message and a status not found code
		return Response.status(Status.NOT_FOUND)
				.entity(errorMessage)
				.build();
	}

}
