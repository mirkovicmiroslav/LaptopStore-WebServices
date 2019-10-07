package service;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import javax.annotation.security.PermitAll;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.naming.NamingException;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.endpoint.Endpoint;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.ws.security.wss4j.WSS4JInInterceptor;
import org.apache.cxf.ws.security.wss4j.WSS4JOutInterceptor;

import com.arjuna.mw.wst11.UserTransaction;
import com.arjuna.mw.wst11.UserTransactionFactory;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

import bankClient.Bank;
import bankClient.Bank_Service;
import bankClient.PaymentType;
import beans.UserStatelessRemote;
import handlers.TransactionHandlerResolver;
import storeClient.Store;
import storeClient.Store_Service;

@RequestScoped
@PermitAll
@Path("/user")
public class UserAPI {

	@EJB
	UserStatelessRemote userBean;

	@Path("/payment/{idProduct}")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response payment(PaymentType payment, @PathParam("idProduct") int idProduct) throws NamingException {
		UserTransaction tx = UserTransactionFactory.userTransaction();
		try {
			tx.begin();

			Bank_Service bankService = new Bank_Service();
			Bank bankPort = bankService.getBankImplPort();
			
			Helper.setSecurity(bankPort);
			
			bankService.setHandlerResolver(new TransactionHandlerResolver());

			boolean pay = bankPort.addTransaction(payment);
			System.out.println(pay);

			Store_Service storeService = new Store_Service();
			Store storePort = storeService.getStoreImplPort();
			
			Helper.setSecurity(storePort);
			
			storeService.setHandlerResolver(new TransactionHandlerResolver());

			String decodedUserAndPass = new String(new Base64().decode(AuthenticationAPI.accessToken));
			StringTokenizer tokenizer = new StringTokenizer(decodedUserAndPass, ":");
			String email = tokenizer.nextToken();

			boolean addTr = storePort.addTransaction(idProduct, userBean.getIdUser(email), payment.getAmount(), pay);
			System.out.println(addTr);

			if (pay && addTr) {
				tx.commit();

				return Response.ok().entity(true).build();
			} else if (!pay && addTr) {
				tx.commit();

				return Response.ok().entity(false).build();
			} else {
				tx.rollback();
				return Response.status(Response.Status.BAD_REQUEST).build();
			}

		} catch (Exception e) {
			e.printStackTrace();
			try {
				tx.rollback();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			return Response.ok("Exception...").build();
		}
	}
}
