package academy.digitallab.store.product;

import academy.digitallab.store.product.entity.Category;
import academy.digitallab.store.product.entity.Product;
import academy.digitallab.store.product.repository.CategoryRepository;
import academy.digitallab.store.product.repository.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Date;
import java.util.List;

@DataJpaTest
public class ProductRepositoryMockTest {

    /*@Autowired
    private ProductServiceImpl productService;

     */

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void whenFindByCategory_thenReturnListProduct(){
        Category category01 = Category.builder().name("Otra 2").build();
        Category category1 = categoryRepository.save(category01);
        Product product01 = Product.builder()
                .name("computer 1")
                .category(category1)
                .description("")
                .stock(Double.parseDouble("10"))
                .price(Double.parseDouble("1240.99"))
                .status("CREATED")
                .createAt(new Date())
                .build();

        productRepository.save(product01);
        List<Product> found = productRepository.findProductsByCategory(product01.getCategory());
        Assertions.assertEquals(1, found.size());
    }

}
