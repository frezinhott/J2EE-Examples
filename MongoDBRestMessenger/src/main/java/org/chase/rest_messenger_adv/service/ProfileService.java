package org.chase.rest_messenger_adv.service;

import java.util.Date;
import java.util.List;

import org.chase.rest_messenger_adv.database.MongoMessengerDB;
import org.chase.rest_messenger_adv.database.MongoProfileMap;
import org.chase.rest_messenger_adv.exception.DataNotFoundException;
import org.chase.rest_messenger_adv.model.Profile;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;


/**
 * This Class retrieves and adds user profiles
 * @author Trevor Chase
 *
 */
public class ProfileService {

	private MongoMessengerDB mongoMessengerDb = new MongoMessengerDB();
	private DBCollection profileCollection = mongoMessengerDb.db.getCollection("profiles");
	
	// Seed the message map with some initial values
	public ProfileService(){
		mongoMessengerDb.getInstance();
	}
	
	// Service call to get all profiles.
	public List<Profile> getAllProfiles(){

		MongoProfileMap mongoProfileMap = new MongoProfileMap();
		DBCursor cursor = profileCollection.find();
		
		// returns a collection of messages
		return mongoProfileMap.mongoToProfiles(cursor);
		
	}
	
	public Profile getProfile(String profileName){
		// gets and returns the message that is mapped to the id value
		MongoProfileMap mongoProfileMap = new MongoProfileMap();
		DBCursor cursor = profileCollection.find(new BasicDBObject("profileName", profileName));
		
		Profile profile = mongoProfileMap.mongoToProfile(cursor);
		
		if (profile == null){
			throw new DataNotFoundException("Profile with profileName " + profileName + " not found");
		}
		return profile;		
	}
	
	public Profile addProfile(Profile profile){
		// Order id Descending order
		BasicDBObject searchQuery = new BasicDBObject("id", -1);
		
		// Find the 1st Document with the highest id
		DBCursor cursor = profileCollection.find().sort(searchQuery).limit(1);
		
		MongoProfileMap mongoProfileMap = new MongoProfileMap();
		Profile lastProfile = mongoProfileMap.mongoToProfile(cursor);
		
		// Set the id to the next available id
		long newId = lastProfile.getId() + 1;		
		
		// Update the new comment with the comment and message Ids
		profile.setId(newId);
		
		BasicDBObject newProfile = new BasicDBObject();
		newProfile.put("id", newId);
		newProfile.put("profileName", profile.getProfileName());
		newProfile.put("lastName", profile.getLastName());
		newProfile.put("firstName", profile.getFirstName());
		newProfile.put("created", new Date());

		// Insert the message into the messages Collection
		profileCollection.insert(newProfile);		
		
		return profile;

	}
	
	public Profile updateProfile(Profile profile){
		// If the profile has not been created yet, return null
		if(profile.getProfileName().isEmpty()){
			return null;
		}
		
		BasicDBObject updatedProfile = new BasicDBObject();
		updatedProfile.put("id", profile.getId());
		updatedProfile.put("profileName", profile.getProfileName());
		updatedProfile.put("lastName", profile.getLastName());
		updatedProfile.put("firstName", profile.getFirstName());
		updatedProfile.put("created", profile.getCreated());

		// Save the profile into the profiles Collection
		profileCollection.save(updatedProfile);		
		
		return profile;			
	}
	
	// Remove and return the profile that was removed
	public Profile removeProfile(String profileName){
		
		// Get the profile from the DB
		BasicDBObject query = new BasicDBObject("profileName", profileName);
		DBCursor cursor = profileCollection.find(query);
		
		// Populate the Profile that is about to be removed
		MongoProfileMap mongoProfileMap = new MongoProfileMap();
		Profile profile = mongoProfileMap.mongoToProfile(cursor);
		
		// Remove the profile from Mongo
		profileCollection.remove(query);
		
		return profile;	
	}

}
