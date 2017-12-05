package org.chase.rest_messenger_adv.resources;

import java.net.URI;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Response.Status;

import org.chase.rest_messenger_adv.model.Comment;
import org.chase.rest_messenger_adv.service.CommentService;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CommentResource {

	CommentService commentService = new CommentService();
	
	/**
	 * Get all comments
	 * http://localhost:8080/RestMessengerAdv/api/messages/{messageId]/comments
	 * 
	 * Get all comments for any given year
	 * http://localhost:8080/RestMessengerAdv/api/comments?year=variable
	 * 
	 * Get #=size comments starting at id=start
	 * http://localhost:8080/RestMessengerAdv/api/comments?start=variable&size=variable
	 * 
	 * @return returns a list of all comments
	 */
	@GET
	public Response getComments(@Context UriInfo uriInfo,
									 @PathParam("messageId") long messageId){
		List<Comment> comments = commentService.getAllComments(messageId);
		
		for(Comment comment : comments){
			// Construct the URI link to self
			String uriSelf = getUriForSelf(uriInfo, messageId, comment);		
			
			// Add the URI link to self
			comment.addLink(uriSelf, "self");			
		}
		
		return Response.status(Status.OK)
				// Add the new message to the Response
				.entity(comments)
				// Build the Response
				.build();
	}

	/**
	 * http://localhost:8080/RestMessengerAdv/api/messages/{messageId}/comments/[commentId}
	 * 
	 * @return returns the comments corresponding to the messageId
	 */
	@GET
	@Path("/{commentId}")
	public Response getComment(@PathParam("messageId") long messageId,
						   	  @PathParam("commentId") long commentId,
						   	  @Context UriInfo uriInfo){
		Comment comment = commentService.getComment(messageId, commentId);
		
		// Construct the URI link to self
		String uriSelf = getUriForSelf(uriInfo, messageId, comment);		
		
		// Add the URI link to self
		comment.addLink(uriSelf, "self");
		
		return Response.status(Status.OK)
				// Add the new message to the Response
				.entity(comment)
				// Build the Response
				.build();

	}
	
	/**
	 * This method constructs the URI link to self
	 * http://localhost:8080/RestMessengerAdv/api/messages/{messageId}/comments/{commentId}
	 * 
	 * @param uriInfo
	 * @param message
	 * @return
	 */
	private String getUriForSelf(UriInfo uriInfo, long messageId, Comment comment) {
		// Build the URI link
		// http://localhost:8080/RestMessengerAdv/api
		String uri = uriInfo.getBaseUriBuilder()
				// Add /messages
				.path(MessageResource.class)
				// Add /{messageId}/comments
				// Pass in the resource class and the method that has the @Path annotation
				.path(MessageResource.class, "getCommentResource")
				// Add /{commentId}
				.path(Long.toString(comment.getId()))
				// Add the messageId to the {messageId} variable
				.resolveTemplate("messageId", messageId)
				// Build the URI
				.build()
				// Convert the URI to a String
				.toString();
		
		return uri;
	}

	/**
	 * http://localhost:8080/RestMessengerAdv/api/messages/[messageId}/comments
	 * Adds a new comment
	 * 
	 * @return returns the newly added comment
	 */
	@POST
	public Response addComment(@PathParam("messageId") long messageId, 
							   @Context UriInfo uriInfo, Comment comment){
		// Add the new message
		Comment newComment = commentService.addComment(messageId, comment);
		
		// Construct the URI link to self
		String uriSelf = getUriForSelf(uriInfo, messageId, newComment);		
		
		// Add the URI link to self
		newComment.addLink(uriSelf, "self");
		
		// Assign the comment ID to a string value
		String newId = String.valueOf(newComment.getId());
		
		// Create a new URI with the comment ID in it and build
		URI uri =uriInfo.getAbsolutePathBuilder().path(newId).build();
		
		// Set the Response status to 201 (CREATED)
		return Response.created(uri)
				// Add the new comment to the Response
				.entity(newComment)
				// Build the Response
				.build();
	}
	
	/**
	 * http://localhost:8080/RestMessengerAdv/api/messages/{messageId}/comments/{commentId}
	 * Updates an existing comment
	 * 
	 * @return returns the updated comment corresponding to the commentId
	 */
	@PUT
	@Path("/{commentId}")
	public Response updateComment(@Context UriInfo uriInfo,
								 @PathParam("commentId") long commentId, 
								 @PathParam("messageId") long messageId, 
								 Comment comment){
		Comment updatedComment = commentService.updateComment(commentId, comment);
		
		// Construct the URI link to self
		String uriSelf = getUriForSelf(uriInfo, messageId, updatedComment);		
		
		// Add the URI link to self
		updatedComment.addLink(uriSelf, "self");
		
		// Set the Response status to 204 (NO_CONTENT)
		return Response.status(Status.NO_CONTENT)
				// Add the new message to the Response
				.entity(updatedComment)
				// Build the Response
				.build();
	}
	
	/**
	 * http://localhost:8080/RestMessengerAdv/api/messages/{messageId}/comments/{commentId}
	 * Deletes an existing comment
	 * 
	 * @return returns the deleted comment corresponding to the commentId
	 */
	@DELETE
	@Path("/{commentId}")
	public Response deleteComment(@PathParam("messageId") long messageId,
								 @PathParam("commentId") long commentId){
		Comment comment = commentService.removeComment(messageId, commentId);
		return Response.status(Status.OK)
				// Add the new message to the Response
				.entity(comment)
				// Build the Response
				.build();
	}
}
