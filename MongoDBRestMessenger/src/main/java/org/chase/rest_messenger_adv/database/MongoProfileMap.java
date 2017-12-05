package org.chase.rest_messenger_adv.database;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.chase.rest_messenger_adv.model.Profile;

import com.mongodb.DBCursor;
import com.mongodb.DBObject;

public class MongoProfileMap {
	
	public Profile mongoToProfile(DBCursor cursor){
		
		Profile profile = new Profile();
		
		if(cursor.hasNext()){
			DBObject obj = cursor.next();
			profile.setId((long)obj.get("id"));
			profile.setProfileName((String)obj.get("profileName"));
			profile.setFirstName((String)obj.get("firstName"));
			profile.setLastName((String)obj.get("lastName"));
			profile.setCreated((Date)obj.get("created"));
				
			return profile;
		}
		return null;
	}

	public List<Profile> mongoToProfiles(DBCursor cursor){
		
		List<Profile> profiles = new ArrayList<Profile>();
		
		while (cursor.hasNext()) {
			DBObject obj = cursor.next();
			Profile profile = new Profile();
			profile.setId((long)obj.get("id"));
			profile.setProfileName((String)obj.get("profileName"));
			profile.setFirstName((String)obj.get("firstName"));
			profile.setLastName((String)obj.get("lastName"));
			profile.setCreated((Date)obj.get("created"));
			
			profiles.add(profile);
		}
		
		return profiles;
	}	
}
