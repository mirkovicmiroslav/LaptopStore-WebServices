package security;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.Provider;

import org.jboss.resteasy.core.Headers;
import org.jboss.resteasy.core.ResourceMethodInvoker;
import org.jboss.resteasy.core.ServerResponse;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

import beans.UserStatelessRemote;

@Provider
public class SecurityInterceptor implements ContainerRequestFilter {

	@EJB
	UserStatelessRemote userBean;

	private static final String AUTHORIZATION_PROPERTY = "Authorization";
	private static final String AUTHORIZATION_SCHEME = "Basic";
	private static final ServerResponse ACCESS_DENIED = new ServerResponse("ACCESS_DENIED", 401, new Headers<Object>());
	private static final ServerResponse SERVER_ERROR = new ServerResponse("SERVER_ERROR", 500, new Headers<Object>());
	private static final ServerResponse ACCESS_FORBIDDEN = new ServerResponse("ACCESS_FORBIDDEN", 403,
			new Headers<Object>());

	@Override
	public void filter(ContainerRequestContext context) throws IOException {

		ResourceMethodInvoker methodInvoker = (ResourceMethodInvoker) context
				.getProperty("org.jboss.resteasy.core.ResourceMethodInvoker");

		Method method = methodInvoker.getMethod();
		if (method.getName().equals("login") || method.getName().equals("register") || method.getName().equals("getAllProducts") || method.getName().equals("getProduct")) {

		} else {
			MultivaluedMap<String, String> mvmap = context.getHeaders();
			List<String> aproperies = mvmap.get(AUTHORIZATION_PROPERTY);

			if (aproperies == null || aproperies.isEmpty()) {
				System.out.println("1");
				context.abortWith(ACCESS_DENIED);
				return;
			}

			String encodedUserAndPass = aproperies.get(0).replaceFirst(AUTHORIZATION_SCHEME + " ", "");

			String decodedUserAndPass = new String(new Base64().decode(encodedUserAndPass));

			StringTokenizer tokenizer = new StringTokenizer(decodedUserAndPass, ":");
			String username = tokenizer.nextToken();
			String password = tokenizer.nextToken();
			System.out.println(username + " " + password);
			System.out.println(userBean.isUserOk(username, password));
			if (userBean.isUserOk(username, password).equals("ADMIN")
					|| userBean.isUserOk(username, password).equals("USER")) {

			} else {
				System.out.println("2");
				context.abortWith(ACCESS_DENIED);
				return;
			}

			if (method.isAnnotationPresent(RolesAllowed.class)) {
				RolesAllowed rolesAllowed = method.getAnnotation(RolesAllowed.class);
				Set<String> listRoles = new HashSet<String>(Arrays.asList(rolesAllowed.value()));

				String role = userBean.isUserOk(username, password);

				if (!listRoles.contains(role)) {
					System.out.println("3");
					context.abortWith(ACCESS_FORBIDDEN);
					return;
				}

			}
		}
	}

}