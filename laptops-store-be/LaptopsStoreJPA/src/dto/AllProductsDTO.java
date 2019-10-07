package dto;

import java.util.List;

public class AllProductsDTO {

	List<ProductDTO> products;
	
	public AllProductsDTO() {
		
	}

	public AllProductsDTO(List<ProductDTO> products) {
		this.products = products;
	}

	public List<ProductDTO> getProducts() {
		return products;
	}

	public void setProducts(List<ProductDTO> products) {
		this.products = products;
	}

}
