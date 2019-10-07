package service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.security.PermitAll;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.naming.NamingException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.annotations.jaxrs.PathParam;

import com.arjuna.mw.wst11.UserTransaction;
import com.arjuna.mw.wst11.UserTransactionFactory;

import beans.UserStatelessRemote;
import dto.AllProductsDTO;
import dto.ProductDTO;
import handlers.TransactionHandlerResolver;
import storeClient.ProductType;
import storeClient.Store;
import storeClient.Store_Service;

@RequestScoped
@Path("/product")
public class ProductAPI {

	@EJB
	UserStatelessRemote userBean;

	@Path("/getAllProducts")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@PermitAll
	public Response getAllProducts() throws NamingException {
		UserTransaction tx = UserTransactionFactory.userTransaction();
		try {
			tx.begin();

			Store_Service service = new Store_Service();
			Store port = service.getStoreImplPort();
			
			Helper.setSecurity(port);
			
			service.setHandlerResolver(new TransactionHandlerResolver());

			List<ProductDTO> listProducts = new ArrayList<>();
			AllProductsDTO allProducts = new AllProductsDTO();

			List<ProductType> productList = port.getAllProducts("");
			if (productList.isEmpty()) {
				tx.rollback();
				return Response.status(Response.Status.BAD_REQUEST).build();
			} else {
				tx.commit();
				for (ProductType pr : productList) {
					ProductDTO product = new ProductDTO();
					product.setIdProduct(pr.getIdProduct());
					product.setBrand(pr.getBrand());
					product.setGraphicCard(pr.getGraphicCard());
					product.setHardDrive(pr.getHardDrive());
					product.setImage(pr.getImage());
					product.setPrice(pr.getPrice());
					product.setProcessor(pr.getProcessor());
					product.setRam(pr.getRam());

					listProducts.add(product);
				}
				allProducts.setProducts(listProducts);
				return Response.ok().entity(allProducts).build();

			}
		} catch (Exception e) {
			System.out.println("ovde");
			try {
				System.out.println("eeeee");
				tx.rollback();
			} catch (Exception e1) {
				System.out.println("aaaaaa");
				e1.printStackTrace();
			}
			System.out.println("ooo");
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
	}

	@Path("/getProduct/{idProduct}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@PermitAll
	public Response getProduct(@PathParam("idProduct") Integer idProduct) {
		UserTransaction tx = UserTransactionFactory.userTransaction();
		try {
			tx.begin();

			Store_Service service = new Store_Service();
			Store port = service.getStoreImplPort();
			
			Helper.setSecurity(port);
			
			service.setHandlerResolver(new TransactionHandlerResolver());

			ProductType product = port.getProduct(idProduct);

			if (product != null) {
				tx.commit();
				return Response.ok().entity(product).build();
			} else {
				tx.rollback();
				return Response.status(Response.Status.BAD_REQUEST).build();
			}

		} catch (Exception e) {
			try {
				tx.rollback();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			return Response.status(Response.Status.BAD_REQUEST).build();
		}

	}
}
