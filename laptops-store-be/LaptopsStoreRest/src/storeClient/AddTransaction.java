
package storeClient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="idProduct" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="idUser" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="price" type="{http://www.w3.org/2001/XMLSchema}float"/&gt;
 *         &lt;element name="paymentSuccess" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "idProduct",
    "idUser",
    "price",
    "paymentSuccess"
})
@XmlRootElement(name = "addTransaction")
public class AddTransaction {

    protected int idProduct;
    protected int idUser;
    protected float price;
    protected boolean paymentSuccess;

    /**
     * Gets the value of the idProduct property.
     * 
     */
    public int getIdProduct() {
        return idProduct;
    }

    /**
     * Sets the value of the idProduct property.
     * 
     */
    public void setIdProduct(int value) {
        this.idProduct = value;
    }

    /**
     * Gets the value of the idUser property.
     * 
     */
    public int getIdUser() {
        return idUser;
    }

    /**
     * Sets the value of the idUser property.
     * 
     */
    public void setIdUser(int value) {
        this.idUser = value;
    }

    /**
     * Gets the value of the price property.
     * 
     */
    public float getPrice() {
        return price;
    }

    /**
     * Sets the value of the price property.
     * 
     */
    public void setPrice(float value) {
        this.price = value;
    }

    /**
     * Gets the value of the paymentSuccess property.
     * 
     */
    public boolean isPaymentSuccess() {
        return paymentSuccess;
    }

    /**
     * Sets the value of the paymentSuccess property.
     * 
     */
    public void setPaymentSuccess(boolean value) {
        this.paymentSuccess = value;
    }

}
