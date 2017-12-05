package org.chase.rest_messenger_adv.database;

import java.util.Date;
import java.util.List;
import java.util.Set;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.Mongo;

public class MongoDBTest {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
		// Connection to the MongoDB Server
		Mongo mongo =  new Mongo("localhost", 27017);
		
		// Connect to the MessengerDB
		DB db = mongo.getDB("MessengerDB");
		
		// Get the Collection objects
		DBCollection messageCollection = db.getCollection("messages");
		//DBCollection commentCollection = db.getCollection("comments");
		//DBCollection profileCollection = db.getCollection("profiles");
		
		// List all databases
		System.out.println("Databases:");
		List<String> dbs = mongo.getDatabaseNames();
		for(String dbList : dbs){
			System.out.println(dbList);
		}
		
		// List all Collection names
		System.out.println("messageCollection:");
		Set<String> collectionList = db.getCollectionNames();
		for(String collection : collectionList){
			System.out.println(collection);
		}	
		
		// Create some message Documents (Rows)
		BasicDBObject message1 = new BasicDBObject();
		message1.put("id", 1);
		message1.put("message", "First Message");
		message1.put("created", new Date());
		message1.put("author", "Trevor Chase");
		
		BasicDBObject message2 = new BasicDBObject();
		message2.put("id", 2);
		message2.put("message", "Second Message");
		message2.put("created", new Date());
		message2.put("author", "Barbara Chase");

		// Insert the messages into the messages Collection
		messageCollection.insert(message1);
		messageCollection.insert(message2);
		
		// Print out the messages Collection
		System.out.println("messages: ");
		
		DBCursor cursor = messageCollection.find();
		while(cursor.hasNext()){
			System.out.println(cursor.next());
		}
		
		// UDPATE
		// Create the query criteria
		BasicDBObject messageQuery = new BasicDBObject();
		messageQuery.put("id", 1);
		
		// Create the updated message
		BasicDBObject updatedMessage = new BasicDBObject();
		updatedMessage.put("id", 1);
		updatedMessage.put("message", "First Updated Message");
		updatedMessage.put("created", new Date());
		updatedMessage.put("author", "Trevor Chase");
		
		// Update the 1st message
		messageCollection.update(messageQuery, updatedMessage);
		
		// Print out the messages Collection
		System.out.println("messages: ");
		
		cursor = messageCollection.find();
		while(cursor.hasNext()){
			System.out.println(cursor.next());
		}

		// Order id Descending
		BasicDBObject searchQuery = new BasicDBObject("id", -1);
		
		// Find the 1st Document with the highest id
		cursor = messageCollection.find().sort(searchQuery).limit(1);
		System.out.println("Comment with the Max id: ");
		while(cursor.hasNext()){
			System.out.println(cursor.next());
		}
		
	}

}
