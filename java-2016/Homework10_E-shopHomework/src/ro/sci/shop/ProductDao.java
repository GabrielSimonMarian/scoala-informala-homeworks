package ro.sci.shop;

public interface ProductDao {

	void createProduct();

	void deleteProduct(int productId);

	void getProductById(int productId);

	void getAllProducts();
}
