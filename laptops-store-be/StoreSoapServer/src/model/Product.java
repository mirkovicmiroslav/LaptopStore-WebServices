package model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the Product database table.
 * 
 */
@Entity
@NamedQuery(name="Product.findAll", query="SELECT p FROM Product p")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_product")
	private int idProduct;

	private String battery;

	private String brand;

	private String description;

	@Column(name="graphic_card")
	private String graphicCard;

	@Column(name="hard_drive")
	private String hardDrive;
	
	@Lob
	private byte[] image;

	@Column(name="item_weight")
	private String itemWeight;

	@Column(name="memory_type")
	private String memoryType;

	private String os;

	@Column(name="package_dimension")
	private String packageDimension;

	private double price;

	private String processor;

	@Column(name="RAM")
	private String ram;

	private int stock;

	//bi-directional many-to-one association to Transaction
	@JsonIgnore
	@OneToMany(mappedBy="product")
	private List<Transaction> transactions;

	public Product() {
	}

	public int getIdProduct() {
		return this.idProduct;
	}

	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}

	public String getBattery() {
		return this.battery;
	}

	public void setBattery(String battery) {
		this.battery = battery;
	}

	public String getBrand() {
		return this.brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getGraphicCard() {
		return this.graphicCard;
	}

	public void setGraphicCard(String graphicCard) {
		this.graphicCard = graphicCard;
	}

	public String getHardDrive() {
		return this.hardDrive;
	}

	public void setHardDrive(String hardDrive) {
		this.hardDrive = hardDrive;
	}

	public byte[] getImage() {
		return this.image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public String getItemWeight() {
		return this.itemWeight;
	}

	public void setItemWeight(String itemWeight) {
		this.itemWeight = itemWeight;
	}

	public String getMemoryType() {
		return this.memoryType;
	}

	public void setMemoryType(String memoryType) {
		this.memoryType = memoryType;
	}

	public String getOs() {
		return this.os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public String getPackageDimension() {
		return this.packageDimension;
	}

	public void setPackageDimension(String packageDimension) {
		this.packageDimension = packageDimension;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getProcessor() {
		return this.processor;
	}

	public void setProcessor(String processor) {
		this.processor = processor;
	}

	public String getRam() {
		return this.ram;
	}

	public void setRam(String ram) {
		this.ram = ram;
	}

	public int getStock() {
		return this.stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public List<Transaction> getTransactions() {
		return this.transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	public Transaction addTransaction(Transaction transaction) {
		getTransactions().add(transaction);
		transaction.setProduct(this);

		return transaction;
	}

	public Transaction removeTransaction(Transaction transaction) {
		getTransactions().remove(transaction);
		transaction.setProduct(null);

		return transaction;
	}

}