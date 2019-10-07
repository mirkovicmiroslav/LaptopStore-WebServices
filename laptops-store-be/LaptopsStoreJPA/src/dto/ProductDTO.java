package dto;

public class ProductDTO {

	private int idProduct;
	private byte[] image;
	private String brand;
	private double price;
	private String processor;
	private String ram;
	private String graphicCard;
	private String hardDrive;

	public ProductDTO() {

	}

	public ProductDTO(int idProduct, byte[] image, String brand, double price, String processor, String ram,
			String graphicCard, String hardDrive) {
		this.idProduct = idProduct;
		this.image = image;
		this.brand = brand;
		this.price = price;
		this.processor = processor;
		this.ram = ram;
		this.graphicCard = graphicCard;
		this.hardDrive = hardDrive;
	}

	public int getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getProcessor() {
		return processor;
	}

	public void setProcessor(String processor) {
		this.processor = processor;
	}

	public String getRam() {
		return ram;
	}

	public void setRam(String ram) {
		this.ram = ram;
	}

	public String getGraphicCard() {
		return graphicCard;
	}

	public void setGraphicCard(String graphicCard) {
		this.graphicCard = graphicCard;
	}

	public String getHardDrive() {
		return hardDrive;
	}

	public void setHardDrive(String hardDrive) {
		this.hardDrive = hardDrive;
	}

}
