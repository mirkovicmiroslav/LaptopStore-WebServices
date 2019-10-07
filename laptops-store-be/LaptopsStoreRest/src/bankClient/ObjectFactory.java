
package bankClient;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the bankClient package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: bankClient
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AddTransaction }
     * 
     */
    public AddTransaction createAddTransaction() {
        return new AddTransaction();
    }

    /**
     * Create an instance of {@link PaymentType }
     * 
     */
    public PaymentType createPaymentType() {
        return new PaymentType();
    }

    /**
     * Create an instance of {@link AddTransactionResponse }
     * 
     */
    public AddTransactionResponse createAddTransactionResponse() {
        return new AddTransactionResponse();
    }

}
