package service;

import java.util.HashMap;
import java.util.Map;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.endpoint.Endpoint;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.ws.security.wss4j.WSS4JInInterceptor;
import org.apache.cxf.ws.security.wss4j.WSS4JOutInterceptor;

public class Helper {

	public static void setSecurity(Object port) {
		Client client = ClientProxy.getClient(port);
		Endpoint cxfEndpoint = client.getEndpoint();

		Map<String, Object> outProps = new HashMap<String, Object>();
		outProps.put("action", "Encrypt");
		outProps.put("user", "client");
		outProps.put("passwordCallbackClass", "handlers.ClientKeystorePasswordCallback");
		outProps.put("encryptionPropFile", "resources/clientKeystore.properties");
		outProps.put("encryptionUser", "server");
		outProps.put("encryptionKeyIdentifier", "DirectReference");
		outProps.put("signatureKeyIdentifier", "DirectReference");
		outProps.put("signaturePropFile", "resources/clientKeystore.properties");
		outProps.put("signatureParts",
				"{}{http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd}Timestamp;{}{http://schemas.xmlsoap.org/soap/envelope/}Body;");

		WSS4JOutInterceptor wssOut = new WSS4JOutInterceptor(outProps); // request
		cxfEndpoint.getOutInterceptors().add(wssOut);

		Map<String, Object> inProps = new HashMap<String, Object>();
		inProps.put("action", "Encrypt");
		inProps.put("passwordCallbackClass", "handlers.ClientKeystorePasswordCallback");
		inProps.put("decryptionPropFile", "resources/clientKeystore.properties");
		WSS4JInInterceptor wssIn = new WSS4JInInterceptor(inProps); // response
		cxfEndpoint.getInInterceptors().add(wssIn);
	}

}
