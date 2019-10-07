package service;

import java.util.StringTokenizer;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

import beans.UserStatelessRemote;
import dto.BasicAuthenticationDTO;
import dto.LoginDTO;
import dto.RegisterDTO;
import storeClient.Store;
import storeClient.Store_Service;

@RequestScoped
@Path("/")
public class AuthenticationAPI {

	@EJB
	UserStatelessRemote userBean;
	public static String accessToken;
	Store_Service service = new Store_Service();
	Store port = service.getStoreImplPort();

	@Path("/login")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@PermitAll
	public Response login(LoginDTO userRequest) {
		Helper.setSecurity(port);
		LoginDTO user = userBean.logIn(userRequest);
		if (user != null) {
			String ussPass = user.getEmail() + ":" + user.getPassword() + ":" + user.getRole();
			accessToken = new Base64().encode(ussPass.getBytes());

			return Response.ok().entity(new BasicAuthenticationDTO(accessToken)).build();
		}
		return Response.status(Response.Status.BAD_REQUEST).build();
	}

	@Path("/register")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@PermitAll
	public Response register(RegisterDTO userRequest) {
		Helper.setSecurity(port);
		if (userBean.register(userRequest)) {
			return Response.ok().entity(true).build();
		}
		return Response.status(Response.Status.BAD_REQUEST).build();
	}

	@Path("/getUserFirstName")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@RolesAllowed({ "ADMIN", "USER" })
	public Response getUserFirstName() {
		Helper.setSecurity(port);
		String decodedUserAndPass = new String(new Base64().decode(accessToken));
		StringTokenizer tokenizer = new StringTokenizer(decodedUserAndPass, ":");
		String email = tokenizer.nextToken();
		if (userBean.getUserFirstName(email) != null) {
			return Response.ok().entity(userBean.getUserFirstName(email)).build();
		}
		return Response.status(Response.Status.BAD_REQUEST).build();
	}

}
