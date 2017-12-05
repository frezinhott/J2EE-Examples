package org.chase.rest_messenger_adv.resources;

import java.net.URI;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Response.Status;

import org.chase.rest_messenger_adv.model.Profile;
import org.chase.rest_messenger_adv.service.ProfileService;

/**
 * This resource is accessed by the following URL:
 * http://localhost:8080/RestMessengerAdv/api/messages
 * 
 * @GET 	configures this method to be executed when ever there is a HTTP GET    call on this resource
 * @POST	configures this method to be executed when ever there is a HTTP POST   call on this resource
 * @PUT		configures this method to be executed when ever there is a HTTP PUT    call on this resource
 * @DELETE	configures this method to be executed when ever there is a HTTP DELETE call on this resource
 * 
 * @Path	Adds a sub-resource to the /profiles resource
 * 
 * @PathParam("variable") Adds the {variable} path parameter as a variable in the method
 * 
 * @Consumes: MediaType specifies the input  content format
 * @Produces: MediaType specifies the return content format
 * MediaType.TEXT_PLAIN 		returns plain text
 * MediaType.APPLICATION_XML 	returns xml format.  
 *								JAX-B Annotation (@XmlRootElement) on the message model will be needed.
 * MediaType.APPLICATION_JSON 	returns JSON format.
 * @author Trevor Chase
 *
 */
@Path("/profiles") 
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProfileResource {
	ProfileService profileService = new ProfileService();
	
	/**
	 * http://localhost:8080/RestMessengerAdv/api/profiles
	 * 
	 * @return returns a list of all profiles
	 */
	@GET 
	public Response getProfiles(@Context UriInfo uriInfo){
		List<Profile> profiles = profileService.getAllProfiles();
		
		for(Profile profile : profiles){
			// Construct the URI link to self
			String uriSelf = getUriForSelf(uriInfo, profile);
			
			//System.out.println(profile.getFirstName());
			
			// Add the URI link to self
			profile.addLink(uriSelf, "self");			
		}
		return Response.status(Status.OK)
				// Add the new message to the Response
				.entity(profiles)
				// Build the Response
				.build();
	}

	/**
	 * http://localhost:8080/RestMessengerAdv/api/profiles/{profileName}
	 * 
	 * @return returns the profile corresponding to the profileName
	 */
	@GET
	@Path("/{profileName}")
	public Response getMesaage(@PathParam("profileName") String profileName, @Context UriInfo uriInfo){
		Profile profile = profileService.getProfile(profileName);
		
		// Construct the URI link to self
		String uriSelf = getUriForSelf(uriInfo, profile);
		
		// Add the URI link to self
		profile.addLink(uriSelf, "self");
		
		return Response.status(Status.OK)
				// Add the new message to the Response
				.entity(profile)
				// Build the Response
				.build();
	}
	
	/**
	 * This method constructs the URI link to self
	 * http://localhost:8080/RestMessengerAdv/api/messages/{messageId}
	 * 
	 * @param uriInfo
	 * @param message
	 * @return
	 */
	private String getUriForSelf(UriInfo uriInfo, Profile profile) {
		// Build the URI link
		// http://localhost:8080/RestMessengerAdv/api
		String uri = uriInfo.getBaseUriBuilder()
				// Add /profiles
				.path(ProfileResource.class)
				// Add /{profileName}
				.path(profile.getProfileName())
				// Build the URI
				.build()
				// Convert the URI to a String
				.toString();
		return uri;
	}

	/**
	 * http://localhost:8080/RestMessengerAdv/api/profiles
	 * Adds a new profile
	 * 
	 * @return returns the newly added profile
	 */
	@POST
	public Response addProfile(@Context UriInfo uriInfo, Profile profile){
		// Add the new profile
		Profile newProfile = profileService.addProfile(profile);
		
		// Construct the URI link to self
		String uriSelf = getUriForSelf(uriInfo, profile);
		
		// Add the URI link to self
		profile.addLink(uriSelf, "self");
		
		// Create a new URI with the profile name in it and build
		URI uri =uriInfo.getAbsolutePathBuilder().path(newProfile.getProfileName()).build();
		
		// Set the Response status to 201 (CREATED)
		return Response.created(uri)
				// Add the new profile to the Response
				.entity(newProfile)
				// Build the Response
				.build();
	}
	
	/**
	 * http://localhost:8080/RestMessengerAdv/api/profiles/{profileName}
	 * Updates an existing profile
	 * 
	 * @return returns the updated profile corresponding to the profileName
	 */
	@PUT
	@Path("/{profileName}")
	public Response updateProfile(@Context UriInfo uriInfo,
								 @PathParam("profileName") String profileName, 
								 Profile profile){
		// We must set the profileName in the profile in order to update it
		profile.setProfileName(profileName);
		Profile updatedProfile = profileService.updateProfile(profile);
		
		// Construct the URI link to self
		String uriSelf = getUriForSelf(uriInfo, updatedProfile);
		
		// Add the URI link to self
		updatedProfile.addLink(uriSelf, "self");

		// Set the Response status to 204 (NO_CONTENT)
		return Response.status(Status.NO_CONTENT)
				// Add the new message to the Response
				.entity(updatedProfile)
				// Build the Response
				.build();
	}
	
	/**
	 * http://localhost:8080/RestMessengerAdv/api/profiles/{profileName}
	 * Deletes an existing profile
	 * 
	 * @return returns the deleted profile corresponding to the profileName
	 */
	@DELETE
	@Path("/{profileName}")
	public Response deleteProfile(@PathParam("profileName") String profileName){
		Profile deletedProfile = profileService.removeProfile(profileName);
		return Response.status(Status.OK)
				// Add the new message to the Response
				.entity(deletedProfile)
				// Build the Response
				.build();
	}
	
	/**
	 * http://localhost:8080/RestMessengerAdv/api/profiles/test
	 * 
	 * @return returns the text: Test
	 */
	@GET
	@Path("/test")
	public String getTest(){
		return "Test";
	}
	
	/**
	 * http://localhost:8080/RestMessengerAdv/api/profiles/test/{regExpression: * }
	 * regExpression : \\d+ - only valid if input is a number
	 * 
	 * @return returns the input as long as it meets the regular expression requirements
	 */
	@GET
	@Path("/test/{regExpression : \\d+}")
	public String getExpression(@PathParam("regExpression") String regExpression){
		return regExpression;
	}
}
