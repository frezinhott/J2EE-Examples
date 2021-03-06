package org.chase.REST_Messenger.client;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.chase.REST_Messenger.model.Comment;
import org.chase.REST_Messenger.model.Message;

public class MessengerClient {
	public static void main(String[] args){
		// Jax-RS client
		Client client = ClientBuilder.newClient();
		
		// Construct the base target URL
		WebTarget baseTarget = client.target("http://localhost:8080/REST-Messenger/webapi/");
		
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
		
		List<Comment> comments = new ArrayList<>(message.getComments().values());
		
		// Print the message 
		System.out.println(message.getMessage());
		
		// Print out the message comments
		for(Comment comment : comments){
			System.out.println(comment.getComment());
		}
	}
}
