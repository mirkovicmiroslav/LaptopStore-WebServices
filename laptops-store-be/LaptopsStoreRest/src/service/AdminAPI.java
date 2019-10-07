package service;

import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;

import com.arjuna.mw.wst11.UserTransaction;
import com.arjuna.mw.wst11.UserTransactionFactory;

import dto.FileUploadDTO;
import storeClient.ProductType;
import storeClient.Store;
import storeClient.Store_Service;

@RequestScoped
@RolesAllowed("ADMIN")
@Path("/admin")
public class AdminAPI {

	static byte[] imageUpload;

	@Path("/addProduct")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addProduct(ProductType product) {
		UserTransaction tx = UserTransactionFactory.userTransaction();
		try {
			tx.begin();

			Store_Service service = new Store_Service();
			Store port = service.getStoreImplPort();
			Helper.setSecurity(port);

			product.setImage(imageUpload);
			System.out.println(imageUpload);
			boolean isAdd = port.addProduct(product);
			System.out.println(isAdd);
			if (isAdd) {
				tx.commit();
				return Response.ok().entity(true).build();
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

	@Path("/updateProduct")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateProduct(ProductType product) {
		UserTransaction tx = UserTransactionFactory.userTransaction();
		try {
			tx.begin();

			Store_Service service = new Store_Service();
			Store port = service.getStoreImplPort();
			Helper.setSecurity(port);

			product.setImage(imageUpload);

			boolean isUpdated = port.updateProduct(product);

			if (isUpdated) {
				tx.commit();
				return Response.ok().entity(true).build();
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

	@Path("/uploadImage")
	@POST
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public Response uploadImage(@MultipartForm FileUploadDTO image) {
		Store_Service service = new Store_Service();
		Store port = service.getStoreImplPort();
		Helper.setSecurity(port);

		imageUpload = image.getImage();

		return Response.status(200).entity(true).build();
	}

}
