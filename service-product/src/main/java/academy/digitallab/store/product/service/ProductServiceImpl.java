package academy.digitallab.store.product.service;

import academy.digitallab.store.product.entity.Category;
import academy.digitallab.store.product.entity.Product;
import academy.digitallab.store.product.repository.CategoryRepository;
import academy.digitallab.store.product.repository.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {


    private final ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;


    @Override
    public List<Product> listAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProduct(int id) {
        Optional<Product> product = productRepository.findById(id);
        if(product.isEmpty()) {
            return new Product();
        }
        return productRepository.findById(id).get();
    }

    @Override
    @Transactional
    public Product createProduct(Product product) {
        product.setStatus("CREATED");
        product.setCreateAt(new Date());
        Category category = categoryRepository.save(product.getCategory());
        product.setCategory(category);
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Product product) {
        Product productDB = getProduct(product.getId());
        if(productDB == null){
            return null;
        }
        productDB.setName(product.getName());
        productDB.setDescription(product.getDescription());
        productDB.setCategory(product.getCategory());
        productDB.setPrice(product.getPrice());
        return productRepository.save(productDB);
    }

    @Override
    public Product deleteProduct(int id) {
        Product productDB = getProduct(id);
        if(productDB == null){
            return null;
        }
        productDB.setStatus("DELETED");
        return productRepository.save(productDB);
    }

    @Override
    public List<Product> findByCategory(Category category) {
        return productRepository.findProductsByCategory(category);
    }

    @Override
    public Product updateStock(int id, Double quantity) {
        Product productDB = getProduct(id);
        if(productDB == null){
            return null;
        }
        productDB.setStock(productDB.getStock() + quantity);
        return productRepository.save(productDB);
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> saveAll(List<Product> productList) {
        return productRepository.saveAll(productList);
    }

}
