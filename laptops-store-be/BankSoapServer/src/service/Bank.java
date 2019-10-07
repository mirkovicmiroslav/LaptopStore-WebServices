package service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.2.5-jbossorg-1
 * 2019-07-06T19:31:39.899+02:00
 * Generated source version: 3.2.5-jbossorg-1
 *
 */
@WebService(targetNamespace = "http://www.example.org/bank/", name = "bank")
@XmlSeeAlso({ObjectFactory.class})
public interface Bank {

    @WebMethod(action = "http://www.example.org/bank/addTransaction")
    @RequestWrapper(localName = "addTransaction", targetNamespace = "http://www.example.org/bank/", className = "service.AddTransaction")
    @ResponseWrapper(localName = "addTransactionResponse", targetNamespace = "http://www.example.org/bank/", className = "service.AddTransactionResponse")
    @WebResult(name = "out", targetNamespace = "")
    public boolean addTransaction(
        @WebParam(name = "payment", targetNamespace = "")
        service.PaymentType payment
    );
}