package org.chase.REST_Messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.chase.REST_Messenger.database.DatabaseClass;
import org.chase.REST_Messenger.model.Profile;


/**
 * This Class retrieves and adds user profiles
 * @author Trevor Chase
 *
 */
public class ProfileService {

	private Map<String, Profile> profiles = DatabaseClass.getProfiles();
	
	// Seed the message map with some initial values
	public ProfileService(){
		profiles.put("tchase", new Profile(1L, "tchase", "Trevor", "Chase"));
		profiles.put("bchase", new Profile(2L, "bchase", "Barbara", "Chase"));
	}
	
	// Service call to get all profiles.  In the real world we would connect to a DB to retrieve these.
	public List<Profile> getAllProfiles(){
		// profiles.values() returns a collection of profiles in the map
		return new ArrayList<Profile>(profiles.values());
		
	}
	
	public Profile getProfile(String profileName){
		// gets and returns the message that is mapped to the id value
		return profiles.get(profileName);
	}
	
	public Profile addProfile(Profile profile){
		// Set the id to the next available id
		profile.setId(profiles.size() + 1);
		
		// Adds a profile to the map
		profiles.put(profile.getProfileName(), profile);
		
		return profile;
	}
	
	public Profile updateProfile(Profile profile){
		// If the profile has not been created yet, return null
		if(profile.getProfileName().isEmpty()){
			return null;
		}
		
		// Updates the profile in the map
		profiles.put(profile.getProfileName(), profile);
		
		return profile;		
	}
	
	public Profile removeProfile(String profileName){
		// Remove and return the profile that was removed
		return profiles.remove(profileName);
	}

}
