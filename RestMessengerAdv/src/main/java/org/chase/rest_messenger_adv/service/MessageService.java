package org.chase.rest_messenger_adv.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.chase.rest_messenger_adv.database.DatabaseClass;
import org.chase.rest_messenger_adv.exception.DataNotFoundException;
import org.chase.rest_messenger_adv.model.Comment;
import org.chase.rest_messenger_adv.model.Message;

/**
 * This Class retrieves and adds messages
 * @author Trevor Chase
 *
 */
public class MessageService {
	
	private Map<Long, Message> messages = DatabaseClass.getMessages();
	
	// Seed the message map with some initial values
	public MessageService(){
		Comment comment1 = new Comment(1L, "Trevor's First Comment", "Trevor Chase");
		Comment comment2 = new Comment(1L, "Barbara's First Comment", "Barbara Chase");
		messages.put(1L, new Message(1L, "First Message", "Trevor Chase", comment1));
		messages.put(2L, new Message(2L, "Second Message", "Barbara Chase", comment2));
	}
	
	// Service call to get all messages.  In the real world we would connect to a DB to retrieve these.
	public List<Message> getAllMessages(){
		// message.values() returns a collection of messages in the map
		return new ArrayList<Message>(messages.values());
		
	}
	
	// Gets all Messages for any given year
	public List<Message> getAllMessagesForYear(int year){
		List<Message> messagesForYear = new ArrayList<>();
		
		// Get a calendar instance to compare the year
		Calendar calendar = Calendar.getInstance();
		
		// Loop through every Message to see if it matches the identified year
		for(Message message : messages.values()){
			// Sets the calendar date/time to its input
			calendar.setTime(message.getCreated());
			// If the calendar year matches the input year, add the message
			if(calendar.get(Calendar.YEAR) == year){
				messagesForYear.add(message);
			}
		}
		return messagesForYear;
	}
	
	// Gets #=size Messages beginning at the id=start 
	public List<Message> getAllMessagesPagenated(int start, int size){
		// Initialize the list with all the messages in the map
		ArrayList<Message> list = new ArrayList<>(messages.values());
		
		// If the input parameters are invalid, return and empty list
		if(start + size > list.size())
			return new ArrayList<Message>();
		
		// Return the sub list
		return list.subList(start, start + size);
	}
	
	public Message getMessage(long id){
		// gets and returns the message that is mapped to the id value
		Message message = messages.get(id);
		if (message == null){
			throw new DataNotFoundException("Message with ID " + id + " not found");
		}
		return message;
	}
	
	public Message addMessage(Message message){
		// Set the id to the next available id
		message.setId(messages.size() + 1);
		
		// Adds a message to the map
		messages.put(message.getId(), message);
		
		return message;
	}
	
	public Message updateMessage(Message message){
		// If the message has not been created yet, return null
		if(message.getId() <= 0){
			return null;
		}
		
		// Updates the message in the map
		messages.put(message.getId(), message);
		
		return message;		
	}
	
	public Message removeMessage(long id){
		// Remove and return the message that was removed
		return messages.remove(id);
	}
	
	public Message addComment(Message message, Comment comment){
		// If the message has not been created yet, return null
		if(message.getId() <= 0){
			return null;
		}
		
		// Get all comments for the message
		Map<Long, Comment> comments = message.getComments();
		
		// Add comment to the message
		comments.put((long)comments.size() + 1 , comment);
		message.setComments(comments);
		
		// Updates the message in the map
		messages.put(message.getId(), message);
		// Add comment are return the updated Message
		return message;
	}

}
