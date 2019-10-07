package handlers;

import org.apache.wss4j.dom.handler.WSHandlerConstants;

public class WsInInterceptor extends org.apache.cxf.ws.security.wss4j.WSS4JInInterceptor {
	public WsInInterceptor() {
		super();
		getProperties().put(WSHandlerConstants.ACTION, "Encrypt");
		getProperties().put(WSHandlerConstants.DEC_PROP_FILE, "resources/serverKeystore.properties");
		getProperties().put(WSHandlerConstants.PW_CALLBACK_CLASS, "handlers.ServerKeystorePasswordCallback");
		getProperties().put(WSHandlerConstants.SIGNATURE_USER, "client");
		getProperties().put(WSHandlerConstants.SIG_PROP_FILE, "resources/serverKeystore.properties");

	}

}