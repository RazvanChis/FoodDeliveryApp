package viewmodel;

import java.util.ArrayList;

import model.Product;

public interface ProductDAOService {

	public boolean addProduct(Product product);

	public void deleteProduct(int productId);

	public ArrayList<Product> getAllProducts();

	public boolean updateProduct(Product product);

}
