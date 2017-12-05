package org.chase.rest_messenger_adv.database;

import java.util.HashMap;
import java.util.Map;

import org.chase.rest_messenger_adv.model.Comment;
import org.chase.rest_messenger_adv.model.Message;
import org.chase.rest_messenger_adv.model.Profile;

/**
 * This Class simulates a database in memory.
 * @author Trevor Chase
 *
 */
public class DatabaseClass {

	private static Map<Long, Message> messages = new HashMap<>();
	private static Map<String, Profile> profiles = new HashMap<>();
	private static Map<Long, Comment> comments = new HashMap<>();
	
	public static Map<Long, Message> getMessages() {
		return messages;
	}
	public static void setMessages(Map<Long, Message> messages) {
		DatabaseClass.messages = messages;
	}
	public static Map<String, Profile> getProfiles() {
		return profiles;
	}
	public static void setProfiles(Map<String, Profile> profiles) {
		DatabaseClass.profiles = profiles;
	}
	public static Map<Long, Comment> getComments() {
		return comments;
	}
	public static void setComments(Map<Long, Comment> comments) {
		DatabaseClass.comments = comments;
	}
		
}
