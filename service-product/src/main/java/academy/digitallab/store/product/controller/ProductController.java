package academy.digitallab.store.product.controller;

import academy.digitallab.store.product.entity.Category;
import academy.digitallab.store.product.entity.ErrorMessage;
import academy.digitallab.store.product.entity.Product;
import academy.digitallab.store.product.repository.CategoryRepository;
import academy.digitallab.store.product.service.ProductService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryRepository categoryRepository;

    private String formatMessage(BindingResult result){
        List<Map<String, String>> errors = result.getFieldErrors().stream()
                .map(err -> {
                    Map<String, String> error = new HashMap<>();
                    error.put(err.getField(), err.getDefaultMessage());
                    return error;
                }).toList();
        ErrorMessage errorMessage = ErrorMessage.builder()
                .code("01")
                .messages(errors)
                .build();
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = "";
        try {
            jsonString = mapper.writeValueAsString(errorMessage);
        } catch (JsonProcessingException e){
            e.printStackTrace();
        }
        return jsonString;
    }


    @GetMapping("/byCategory/{categoryId}")
    public ResponseEntity<List<Product>> getListProducts(@PathVariable(name = "categoryId", required = false) Long categoryId) {
        Category category1 = Category.builder().name("Otra 2").build();
        categoryRepository.save(category1);
        Category category2 = Category.builder().name("Otra 3").build();
        categoryRepository.save(category2);
        Product computer = Product.builder()
                .id(1)
                .name("computer")
                .category(category1)
                .price(12.5)
                .stock(5.0)
                .build();
        Product pen = Product.builder()
                .id(2)
                .name("pen")
                .category(category1)
                .price(8.0)
                .stock(10.0)
                .build();
        List<Product> products = new ArrayList<>();
        products.add(computer);
        products.add(pen);
        productService.saveAll(products);
        List<Product> productss;
        System.out.println(categoryId);
        if (categoryId != null){
            int id = Math.toIntExact(categoryId);
            productss = productService.findByCategory(categoryRepository.getReferenceById(id));
        }
        else {
            productss = productService.listAllProducts();
        }


        if (productss.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(productss);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable(name = "id", required = false) Long id){
        Category category1 = Category.builder().name("Otra 2").build();
        categoryRepository.save(category1);
        Category category2 = Category.builder().name("Otra 3").build();
        categoryRepository.save(category2);
        Product computer = Product.builder()
                .id(1)
                .name("computer")
                .category(category1)
                .price(12.5)
                .stock(5.0)
                .build();
        Product pen = Product.builder()
                .id(2)
                .name("pen")
                .category(category1)
                .price(8.0)
                .stock(10.0)
                .build();
        List<Product> products = new ArrayList<>();
        products.add(computer);
        products.add(pen);
        productService.saveAll(products);
        Product product = productService.getProduct(Math.toIntExact(id));
        if(null == product) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(product);
    }


    @PostMapping
    public ResponseEntity<Product> createProduct(@Valid @RequestBody Product product, BindingResult result){
        if(result.hasErrors()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, this.formatMessage(result));
        }
        Product productCreated = productService.createProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(productCreated);
    }


    @PutMapping
    public ResponseEntity<Product> updateProduct(@RequestBody Product product){
        Product productUpdated = productService.updateProduct(product);
        if(productUpdated == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(productUpdated);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable(name = "id") int id){
        Product productDeleted = productService.deleteProduct(id);
        if(productDeleted == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(productDeleted);
    }


    @GetMapping("/{id}/{quantity}")
    public ResponseEntity<Product> updateStock(@PathVariable(name = "id") int id, @PathVariable(name = "quantity") Double quantity){
        Product productUpdated = productService.updateStock(id, quantity);
        if(productUpdated == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(productUpdated);
    }



}
