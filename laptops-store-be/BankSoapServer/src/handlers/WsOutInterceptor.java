package handlers;

import org.apache.wss4j.dom.handler.WSHandlerConstants;

public class WsOutInterceptor extends org.apache.cxf.ws.security.wss4j.WSS4JOutInterceptor {
	public WsOutInterceptor() {
		super();
		getProperties().put(WSHandlerConstants.ACTION, "Encrypt");
		getProperties().put(WSHandlerConstants.ENC_PROP_FILE, "resources/serverKeystore.properties");
		getProperties().put(WSHandlerConstants.PW_CALLBACK_CLASS, "handlers.ServerKeystorePasswordCallback");
		getProperties().put(WSHandlerConstants.ENCRYPTION_USER, "client");
	}
}