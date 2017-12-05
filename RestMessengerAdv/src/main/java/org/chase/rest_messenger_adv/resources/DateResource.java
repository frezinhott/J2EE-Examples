package org.chase.rest_messenger_adv.resources;

import java.util.Calendar;
import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.chase.rest_messenger_adv.MyDate;

/**
 * This Resource will produce the date/time when the following resource URL is accessed:
 * http://localhost:8080/RestMessengerAdv/api/date
 * @author Trevor Chase
 *
 */
@Path("date")
public class DateResource {

	/**
	 * This method will use the custom MyDateConverterProvider class to convert the 
	 * dateString (today, yesterday or tomorrow) into a Date object and then return
	 * plain text for the message body. 
	 * @param myDate
	 * @return
	 */
	@Path("/{dateString}")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getRequestedDate(@PathParam("dateString") MyDate myDate){
		return myDate.toString();
	}
	
	/**
	 * This method will use the custom DateMessageBodyWriter class to convert the current date
	 * into plain text in the returned message body.
	 * @return
	 */
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public Date getRequestedDatePlainText(){
		return Calendar.getInstance().getTime();
	}
	
	/**
	 * This method will use the custom DateMessageBodyWriter class to convert the current date
	 * into a customer Media Type (text/shortdate) using the custom ShortDateMessageBodyWriter class
	 * in the returned message body.
	 * 
	 * http://localhost:8080/RestMessengerAdv/api/date/
	 * Header Values:
	 * Key: Accept
	 * Value: text/shortdate
	 * 
	 * @return
	 */
	@GET
	@Produces("text/shortdate")
	public Date getRequestedDateShortText(){
		return Calendar.getInstance().getTime();
	}
	
}
