package org.chase.rest_messenger_adv;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Calendar;
import java.util.Date;

import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;

/**
 * Every MessageBodyWriter must implement the MessageBodyWriter interface.
 * This class will convert a Date object in the Message Body.  The process is similar
 * when writing a a custom MessageBodyReader.
 * 
 * After creating the class, "add unimplemented methods" to the class
 * @author Trevor Chase
 * 
 * @Provider - Registers the provider to JAX-RS
 * @Produces - This writer will produce a message body written in a custome media type "text/shortdate"
 *
 */

@Provider
@Produces("text/shortdate")
public class ShortDateMessageBodyWriter implements MessageBodyWriter<Date>{

	/**
	 * This method is now deprecated with JAX 2.0.  The recommended best practice is to return -1
	 */
	@Override
	public long getSize(Date arg0, Class<?> arg1, Type arg2, Annotation[] arg3,
			MediaType arg4) {
		
		return -1;
	}

	/**
	 * This method is an implementation that you write to to let Jersey know if this is 
	 * a certain type of something that this writer can handle.
	 * 
	 * If the return type is a Date, then Jersey can handle this conversion and the proceed 
	 * to call the writeTo() method.
	 */
	@Override
	public boolean isWriteable(Class<?> type, Type arg1, Annotation[] arg2,
			MediaType arg3) {
		
		// If the type of the object is a Date, return true
		return Date.class.isAssignableFrom(type);
	}

	/**
	 * This method takes the date instance and then writes it to the output stream.
	 * 
	 * The Produces(MediaType=[value]) will then conver the steam to what ever media type is specified.
	 */
	@Override
	public void writeTo(Date date, 
						Class<?> type, 
						Type type1, 
						Annotation[] antns,
						MediaType mt, 
						MultivaluedMap<String, Object> mm,
						OutputStream out) throws IOException, WebApplicationException {
	
		// Create a calendar instance with the provided Date object
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		
		int month = calendar.get(Calendar.MONTH);
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		int year = calendar.get(Calendar.YEAR);
		
		String shortDate = month + "-" + day + "-" + year;
		
		// Convert the shortDate string to a byte string and write it to the output stream
		out.write(shortDate.getBytes());
		
	}

}
