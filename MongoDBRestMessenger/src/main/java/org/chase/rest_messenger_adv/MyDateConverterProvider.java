package org.chase.rest_messenger_adv;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Calendar;

import javax.ws.rs.ext.ParamConverter;
import javax.ws.rs.ext.ParamConverterProvider;
import javax.ws.rs.ext.Provider;

/**
 * This class will convert a URL string into a MyDate Object when passed as a PathParam
 * @author Trevor Chase
 * 
 * @Provider - Registers the provider to JAX-RS
 *
 */

@Provider
public class MyDateConverterProvider implements ParamConverterProvider {

	@Override
	public <T> ParamConverter<T> getConverter(final Class<T> rawType, Type genericType, Annotation[] annotation) {
		if(rawType.getName().equals(MyDate.class.getName())){
			
			// Return the custom ParamConverter that is implemented inline
			return new ParamConverter<T>(){
				
				@Override
				public T fromString(String value){
					
					Calendar requestedDate = Calendar.getInstance();
					if ("tomorrow".equalsIgnoreCase(value)){
						requestedDate.add(Calendar.DATE, 1);
					}
					else if("yesterday".equalsIgnoreCase(value)){
						requestedDate.add(Calendar.DATE, -1);
					}
					else if("today".equalsIgnoreCase(value)){
						requestedDate.add(Calendar.DATE, 0);
					}
					
					MyDate myDate = new MyDate();
					myDate.setDate(requestedDate.get(Calendar.DATE));
					myDate.setMonth(requestedDate.get(Calendar.MONTH));
					myDate.setYear(requestedDate.get(Calendar.YEAR));
					
					return rawType.cast(myDate);	
				}
		
				@Override
				public String toString(T myBean){
					if(myBean==null){
						return null;
					}
					
					return myBean.toString();
				}
			};
		}
		return null;
	}

}
