package org.chase.rest_messenger_adv.database;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.chase.rest_messenger_adv.model.Comment;

import com.mongodb.DBCursor;
import com.mongodb.DBObject;

public class MongoCommentMap {

	public Comment mongoToComment(DBCursor cursor){

		Comment comment = new Comment();
		
		if(cursor.hasNext()){
			DBObject obj = cursor.next();
			comment.setId((long) obj.get("id"));
			comment.setMessageId((long) obj.get("messageId"));
			comment.setComment((String) obj.get("comment"));
			comment.setCreated((Date) obj.get("created"));
			comment.setAuthor((String) obj.get("author"));
		}
		return comment;
	}
	
	public List<Comment> mongoToComments(DBCursor cursor){
		
		List<Comment> comments = new ArrayList<Comment>();
		
		while (cursor.hasNext()) {
			DBObject obj = cursor.next();
			Comment comment = new Comment();
			comment.setId((long) obj.get("id"));
			comment.setMessageId((long) obj.get("messageId"));
			comment.setComment((String) obj.get("comment"));
			comment.setCreated((Date) obj.get("created"));
			comment.setAuthor((String) obj.get("author"));
			comments.add(comment);
		}
		
		return comments;
	}
	
}
