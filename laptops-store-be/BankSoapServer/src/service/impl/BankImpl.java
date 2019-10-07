package service.impl;

import javax.inject.Inject;
import javax.jws.HandlerChain;
import javax.jws.WebService;

import org.apache.cxf.interceptor.InInterceptors;
import org.apache.cxf.interceptor.OutInterceptors;

import beans.BankStateless;
import service.Bank;

@WebService(serviceName = "bank", endpointInterface = "service.Bank", targetNamespace = "http://www.example.org/bank/")
@HandlerChain(file = "jaxws-handlers-server.xml")
@InInterceptors(interceptors = {"handlers.WsInInterceptor"})
@OutInterceptors(interceptors = {"handlers.WsOutInterceptor"})
public class BankImpl implements Bank {

	@Inject
	BankStateless bankBean;

	public boolean addTransaction(service.PaymentType payment) {
		return bankBean.payment(payment);
	}
}