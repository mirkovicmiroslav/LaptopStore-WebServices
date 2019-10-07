package service;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.2.5-jbossorg-1
 * 2019-07-08T18:35:19.814+02:00
 * Generated source version: 3.2.5-jbossorg-1
 *
 */
@WebServiceClient(name = "store",
                  wsdlLocation = "file:/home/easy/Desktop/workspace/StoreDS/StoreSoapServer/spec/store.wsdl",
                  targetNamespace = "http://www.example.org/store/")
public class Store_Service extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://www.example.org/store/", "store");
    public final static QName StoreSOAP = new QName("http://www.example.org/store/", "storeSOAP");
    static {
        URL url = null;
        try {
            url = new URL("file:/home/easy/Desktop/workspace/StoreDS/StoreSoapServer/spec/store.wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(Store_Service.class.getName())
                .log(java.util.logging.Level.INFO,
                     "Can not initialize the default wsdl from {0}", "file:/home/easy/Desktop/workspace/StoreDS/StoreSoapServer/spec/store.wsdl");
        }
        WSDL_LOCATION = url;
    }

    public Store_Service(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public Store_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public Store_Service() {
        super(WSDL_LOCATION, SERVICE);
    }

    public Store_Service(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public Store_Service(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public Store_Service(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }




    /**
     *
     * @return
     *     returns Store
     */
    @WebEndpoint(name = "storeSOAP")
    public Store getStoreSOAP() {
        return super.getPort(StoreSOAP, Store.class);
    }

    /**
     *
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns Store
     */
    @WebEndpoint(name = "storeSOAP")
    public Store getStoreSOAP(WebServiceFeature... features) {
        return super.getPort(StoreSOAP, Store.class, features);
    }

}
