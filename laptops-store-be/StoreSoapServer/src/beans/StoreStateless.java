package beans;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.Product;
import model.Transaction;
import service.ProductType;

/**
 * Session Bean implementation class StoreStateless
 */
@Stateless
public class StoreStateless {

	@PersistenceContext
	EntityManager em;

	/**
	 * Default constructor.
	 */
	public StoreStateless() {
		// TODO Auto-generated constructor stub
	}

	public List<ProductType> getAllProducts() {
		List<Product> products = em.createQuery("SELECT p FROM Product p WHERE p.stock > 0").getResultList();
		List<ProductType> productsType = new ArrayList<>();

		for (Product product : products) {
			ProductType productType = new ProductType();
			productType.setIdProduct(product.getIdProduct());
			productType.setBattery(product.getBattery());
			productType.setBrand(product.getBrand());
			productType.setDescription(product.getDescription());
			productType.setGraphicCard(product.getGraphicCard());
			productType.setHardDrive(product.getHardDrive());
			productType.setImage(product.getImage());
			productType.setItemWeight(product.getItemWeight());
			productType.setMemoryType(product.getMemoryType());
			productType.setOs(product.getOs());
			productType.setPackageDimension(product.getPackageDimension());
			productType.setPrice(product.getPrice());
			productType.setProcessor(product.getProcessor());
			productType.setRam(product.getRam());
			productType.setStock(product.getStock());

			productsType.add(productType);
		}
		return productsType;
	}

	public ProductType getProduct(int idProduct) {
		Query q = em.createQuery("SELECT p FROM Product p WHERE p.idProduct =:idProduct");
		q.setParameter("idProduct", idProduct);
		Product product = (Product) q.getResultList().get(0);

		ProductType productType = new ProductType();
		productType.setIdProduct(product.getIdProduct());
		productType.setBattery(product.getBattery());
		productType.setBrand(product.getBrand());
		productType.setDescription(product.getDescription());
		productType.setGraphicCard(product.getGraphicCard());
		productType.setHardDrive(product.getHardDrive());
		productType.setImage(product.getImage());
		productType.setItemWeight(product.getItemWeight());
		productType.setMemoryType(product.getMemoryType());
		productType.setOs(product.getOs());
		productType.setPackageDimension(product.getPackageDimension());
		productType.setPrice(product.getPrice());
		productType.setProcessor(product.getProcessor());
		productType.setRam(product.getRam());
		productType.setStock(product.getStock());

		return productType;
	}

	public boolean addProduct(service.ProductType product) {
		Product pr = new Product();

		pr.setIdProduct(product.getIdProduct());
		pr.setBattery(product.getBattery());
		pr.setBrand(product.getBrand());
		pr.setDescription(product.getDescription());
		pr.setGraphicCard(product.getGraphicCard());
		pr.setHardDrive(product.getHardDrive());
		pr.setImage(product.getImage());
		pr.setItemWeight(product.getItemWeight());
		pr.setMemoryType(product.getMemoryType());
		pr.setOs(product.getOs());
		pr.setPackageDimension(product.getPackageDimension());
		pr.setPrice(product.getPrice());
		pr.setProcessor(product.getProcessor());
		pr.setRam(product.getRam());
		pr.setStock(product.getStock());

		em.persist(pr);

		return true;

	}

	public boolean updateProduct(service.ProductType product) {
		Product pr = em.find(Product.class, product.getIdProduct());

		pr.setIdProduct(product.getIdProduct());
		pr.setBattery(product.getBattery());
		pr.setBrand(product.getBrand());
		pr.setDescription(product.getDescription());
		pr.setGraphicCard(product.getGraphicCard());
		pr.setHardDrive(product.getHardDrive());
		pr.setImage(product.getImage());
		pr.setItemWeight(product.getItemWeight());
		pr.setMemoryType(product.getMemoryType());
		pr.setOs(product.getOs());
		pr.setPackageDimension(product.getPackageDimension());
		pr.setPrice(product.getPrice());
		pr.setProcessor(product.getProcessor());
		pr.setRam(product.getRam());
		pr.setStock(product.getStock());

		em.merge(pr);

		return true;
	}

	public boolean addTransaction(int idProduct, int idUser, float price, boolean paymentSuccess) {
		Product pr = em.find(Product.class, idProduct);

		Transaction transaction = new Transaction();
		transaction.setProduct(pr);
		transaction.setPrice(price);
		transaction.setIdUser(idUser);
		transaction.setDate(new Timestamp(System.currentTimeMillis()));

		if (paymentSuccess) {
			transaction.setStatus((byte) 1);
			pr.setStock(pr.getStock() - 1);

			em.merge(pr);

			em.persist(transaction);

			return true;
		} else {
			transaction.setStatus((byte) 0);
			em.persist(transaction);

			return true;
		}

	}

}
