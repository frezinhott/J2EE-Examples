package org.chase.rest_messenger_adv;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * This class maps the application to a Jersey RS application.  It will initialize the application.
 * 
 * @ApplicationPath("api") - Prefixes the Resource URL with api
 * http://localhost:8080/RestMessengerAdv/api
 * 
 * @author Trevor Chase
 *
 */

@ApplicationPath("api")
public class RestApiApp extends Application {

}
