
package storeClient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ProductType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ProductType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="idProduct" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="battery" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="brand" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="graphicCard" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="hardDrive" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="image" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/&gt;
 *         &lt;element name="itemWeight" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="memoryType" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="os" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="packageDimension" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="price" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="processor" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="ram" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="stock" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProductType", propOrder = {
    "idProduct",
    "battery",
    "brand",
    "description",
    "graphicCard",
    "hardDrive",
    "image",
    "itemWeight",
    "memoryType",
    "os",
    "packageDimension",
    "price",
    "processor",
    "ram",
    "stock"
})
public class ProductType {

    protected int idProduct;
    @XmlElement(required = true)
    protected String battery;
    @XmlElement(required = true)
    protected String brand;
    @XmlElement(required = true)
    protected String description;
    @XmlElement(required = true)
    protected String graphicCard;
    @XmlElement(required = true)
    protected String hardDrive;
    @XmlElement(required = true)
    protected byte[] image;
    @XmlElement(required = true)
    protected String itemWeight;
    @XmlElement(required = true)
    protected String memoryType;
    @XmlElement(required = true)
    protected String os;
    @XmlElement(required = true)
    protected String packageDimension;
    protected double price;
    @XmlElement(required = true)
    protected String processor;
    @XmlElement(required = true)
    protected String ram;
    protected int stock;

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
     * Gets the value of the battery property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBattery() {
        return battery;
    }

    /**
     * Sets the value of the battery property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBattery(String value) {
        this.battery = value;
    }

    /**
     * Gets the value of the brand property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBrand() {
        return brand;
    }

    /**
     * Sets the value of the brand property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBrand(String value) {
        this.brand = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the graphicCard property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGraphicCard() {
        return graphicCard;
    }

    /**
     * Sets the value of the graphicCard property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGraphicCard(String value) {
        this.graphicCard = value;
    }

    /**
     * Gets the value of the hardDrive property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHardDrive() {
        return hardDrive;
    }

    /**
     * Sets the value of the hardDrive property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHardDrive(String value) {
        this.hardDrive = value;
    }

    /**
     * Gets the value of the image property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getImage() {
        return image;
    }

    /**
     * Sets the value of the image property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setImage(byte[] value) {
        this.image = value;
    }

    /**
     * Gets the value of the itemWeight property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getItemWeight() {
        return itemWeight;
    }

    /**
     * Sets the value of the itemWeight property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setItemWeight(String value) {
        this.itemWeight = value;
    }

    /**
     * Gets the value of the memoryType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMemoryType() {
        return memoryType;
    }

    /**
     * Sets the value of the memoryType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMemoryType(String value) {
        this.memoryType = value;
    }

    /**
     * Gets the value of the os property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOs() {
        return os;
    }

    /**
     * Sets the value of the os property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOs(String value) {
        this.os = value;
    }

    /**
     * Gets the value of the packageDimension property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPackageDimension() {
        return packageDimension;
    }

    /**
     * Sets the value of the packageDimension property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPackageDimension(String value) {
        this.packageDimension = value;
    }

    /**
     * Gets the value of the price property.
     * 
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the value of the price property.
     * 
     */
    public void setPrice(double value) {
        this.price = value;
    }

    /**
     * Gets the value of the processor property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProcessor() {
        return processor;
    }

    /**
     * Sets the value of the processor property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProcessor(String value) {
        this.processor = value;
    }

    /**
     * Gets the value of the ram property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRam() {
        return ram;
    }

    /**
     * Sets the value of the ram property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRam(String value) {
        this.ram = value;
    }

    /**
     * Gets the value of the stock property.
     * 
     */
    public int getStock() {
        return stock;
    }

    /**
     * Sets the value of the stock property.
     * 
     */
    public void setStock(int value) {
        this.stock = value;
    }

}
