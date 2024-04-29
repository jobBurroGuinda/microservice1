package academy.digitallab.store.product.service;

import academy.digitallab.store.product.entity.Category;
import academy.digitallab.store.product.entity.Product;

import java.util.List;

public interface ProductService {

    public List<Product> listAllProducts();
    public Product getProduct(int id);
    public Product createProduct(Product product);
    public Product updateProduct(Product product);
    public Product deleteProduct(int id);
    public List<Product> findByCategory(Category category);
    public Product updateStock(int id, Double quantity);
    public Product save(Product product);
    public List<Product> saveAll(List<Product> productList);

}
