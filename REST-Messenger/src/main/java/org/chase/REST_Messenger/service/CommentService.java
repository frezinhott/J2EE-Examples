package org.chase.REST_Messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.chase.REST_Messenger.database.DatabaseClass;
import org.chase.REST_Messenger.model.Comment;
import org.chase.REST_Messenger.model.ErrorMessage;
import org.chase.REST_Messenger.model.Message;

/**
 * This Class retrieves and adds comments
 * @author Trevor Chase
 *
 */
public class CommentService {
	
	private Map<Long, Message> messages = DatabaseClass.getMessages();
	
	// Service call to get all comments.  In the real world we would connect to a DB to retrieve these.
	public List<Comment> getAllComments(long messageId){
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		return new ArrayList<Comment>(comments.values());
		
	}
	
	public Comment getComment(long messageId, long commentId){
		ErrorMessage errorMessage = new ErrorMessage("Not Found", 404, "http://link.to.documentation");
		// Return a Response with the JSON error message and a status not found code
		Response response = Response.status(Status.NOT_FOUND)
				.entity(errorMessage)
				.build();
		
		Message message = messages.get(messageId);
		if(message == null){
			// Throw JAX-RS pre-loaded exception (no mapping needed)
			// This is not the preferred method
			throw new WebApplicationException(response);
		}
		
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		
		Comment comment = comments.get(commentId);
		
		if(comment == null){
			// Throw JAX-RS pre-loaded exception (no mapping needed)
			// This is not the preferred method
			throw new NotFoundException(response);
		}
		return comment;
		
	}
	

	public Comment addComment(long messageId, Comment comment){
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		
		// Set the id to the next available id
		comment.setId(messages.get(messageId).getComments().size() + 1);
		
		// Adds a message to the map
		comments.put(comment.getId(), comment);
		
		return comment;
	}
	
	public Comment updateComment(long messageId, Comment comment){
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		
		// If the comment has not been created yet, return null
		if(comment.getId() <= 0){
			return null;
		}
		
		// Updates the comment in the map
		comments.put(comment.getId(), comment);
		
		return comment;		
	}
	
	public Comment removeComment(long messageId, long commentId){
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		
		// Remove and return the comment that was removed
		return comments.remove(commentId);	
	}

}