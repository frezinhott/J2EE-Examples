package org.chase.REST_Messenger.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

//@XmlRootElement - JAX-B annotation to convert the object into XML
@XmlRootElement
public class Comment {
	
	private long id;
	private String comment;
	private Date created;
	private String author;
	private List<Link> links = new ArrayList<>();
	
	// For model classes, ensure that you always have a no argument constructor
	public Comment(){
		
	}
	
	public Comment(long id, String comment, String author){
		this.id=id;
		this.comment=comment;
		this.author=author;
		this.created=new Date();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public List<Link> getLinks() {
		return links;
	}

	public void setLinks(List<Link> links) {
		this.links = links;
	}
	
	// Convenience method to add a link to the links List
	public void addLink(String url, String rel){
		Link link = new Link();
		link.setLink(url);
		link.setRel(rel);
		links.add(link);
	}
}
