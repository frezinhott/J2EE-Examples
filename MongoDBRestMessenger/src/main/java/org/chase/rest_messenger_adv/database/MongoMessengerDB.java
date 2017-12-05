package org.chase.rest_messenger_adv.database;

import com.mongodb.DB;
import com.mongodb.Mongo;

public class MongoMessengerDB {

	private static MongoMessengerDB instance = null;
	public Mongo mongo;
	public DB db;
   
	@SuppressWarnings("deprecation")
	public MongoMessengerDB() {
		// Connection to the MongoDB Server
		setMongo(new Mongo("localhost", 27017));
		
		// Connect to the MessengerDB
		setDb(mongo.getDB("MessengerDB"));	 
	}

	public MongoMessengerDB getInstance() {
		if(instance == null) {
			instance = new MongoMessengerDB();
		}
		return instance;
	}

	public Mongo getMongo() {
		return mongo;
	}

	public void setMongo(Mongo mongo) {
		this.mongo = mongo;
	}

	public DB getDb() {
		return db;
	}

	public void setDb(DB db) {
		this.db = db;
	}
}
