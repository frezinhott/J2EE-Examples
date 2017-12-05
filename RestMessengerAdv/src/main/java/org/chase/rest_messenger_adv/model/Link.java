package org.chase.rest_messenger_adv.model;

/**
 * This class provides likes to other resources to fulfill HATEOAS
 * 
 * @author Trevor Chase
 *
 */
public class Link {
	// Resource URL
	private String link;
	
	// Resource relationship
	private String rel;

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getRel() {
		return rel;
	}

	public void setRel(String rel) {
		this.rel = rel;
	}

}
