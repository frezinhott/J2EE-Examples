package org.chase.rest_messenger_adv.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ErrorMessage {
	private String errorMessge;
	private int errorCode;
	private String documentation;
	
	public ErrorMessage(){
		
	}
	
	public ErrorMessage(String errorMessage, int errorCode, String documentation){
		super();
		this.errorCode=errorCode;
		this.errorMessge=errorMessage;
		this.documentation=documentation;
	}
	
	public String getErrorMessge() {
		return errorMessge;
	}
	public void setErrorMessge(String errorMessge) {
		this.errorMessge = errorMessge;
	}
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	public String getDocumentation() {
		return documentation;
	}
	public void setDocumentation(String documentation) {
		this.documentation = documentation;
	}

}
