package org.chase.REST_Messenger.exception;

public class DataNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2710511422198703701L;
	
	public DataNotFoundException(String message){
		super(message);
	}

}
