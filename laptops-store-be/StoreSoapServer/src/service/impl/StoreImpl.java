package service.impl;

import javax.inject.Inject;
import javax.jws.HandlerChain;
import javax.jws.WebService;

import org.apache.cxf.interceptor.InInterceptors;
import org.apache.cxf.interceptor.OutInterceptors;

import beans.StoreStateless;
import service.Store;

@WebService(serviceName = "store", endpointInterface = "service.Store", targetNamespace = "http://www.example.org/store/")
@HandlerChain(file="jaxws-handlers-server.xml")
@InInterceptors(interceptors = {"handlers.WsInInterceptor"})
@OutInterceptors(interceptors = {"handlers.WsOutInterceptor"})
public class StoreImpl implements Store {

	@Inject
	StoreStateless storeBean;

	public java.util.List<service.ProductType> getAllProducts(java.lang.String in) {
		return storeBean.getAllProducts();
	}

	public service.ProductType getProduct(int idProduct) {
		return storeBean.getProduct(idProduct);
	}

	public boolean addProduct(service.ProductType product) {
		return storeBean.addProduct(product);
	}

	public boolean updateProduct(service.ProductType product) {
		return storeBean.updateProduct(product);
	}

	public boolean addTransaction(int idProduct, int idUser, float price, boolean paymentSuccess) {
		return storeBean.addTransaction(idProduct, idUser, price, paymentSuccess);
	}
}
