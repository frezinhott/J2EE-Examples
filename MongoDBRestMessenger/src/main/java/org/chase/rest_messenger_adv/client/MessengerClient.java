package org.chase.rest_messenger_adv.client;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.chase.rest_messenger_adv.model.Comment;
import org.chase.rest_messenger_adv.model.Message;

public class MessengerClient {
	public static void main(String[] args){
		// Jax-RS client
		Client client = ClientBuilder.newClient();
		
		// Construct the base target URL
		WebTarget baseTarget = client.target("http://localhost:8080/RestMessengerAdv/api/");
		
		// Construct the messages resource target URL
		WebTarget messagesTarget = baseTarget.path("messages");
		
		// Construct the single message target URL with a place holder
		WebTarget singleMessageTarget = messagesTarget.path("{messageId}");
		
		// Point the client to a target resource.  Get the 1st message.
		// .resolveTemplate() replaces the variable to be used in the messageId place holder
		// .request - builds the request.  Accepts what media type the request is expecting
		// .get - posts an HTTP GET
		Response messageResponse = singleMessageTarget
			  .resolveTemplate("messageId", "2")
			  .request(MediaType.APPLICATION_JSON)
			  .get();
		
		// Get the message in the response wrapper
		Message message = messageResponse.readEntity(Message.class);
		
		List<Comment> comments = message.getComments();
		
		// Print the message 
		System.out.println(message.getMessage());
		
		// Print out the comments array size
		System.out.println("comments.size(): " + comments.size());
		System.out.println(message.getComments().toString());
		
		// Print out the message comments
		for(Comment comment : comments){
			System.out.println(comment.getComment());
		}
		
		// Create a new message
		Message newMessage = new Message(5, "New JAX-RS client message", "tchase");
		
		// Add the new message to the messenger service
		// .request - Add a request to the messages resource
		// .post - Post the new message in JSON format to the message resource
		Response postResponse = messagesTarget
			.request()
			.post(Entity.json(newMessage));
		
		// Get an instance of the newly created repose from the POST Response
		Message createdMessage = postResponse.readEntity(Message.class);
		
		// Print the newly created message
		System.out.println(createdMessage.getMessage());
		
	}
}
