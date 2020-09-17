package ee.taltech.backend.controller;

import ee.taltech.backend.exception.InvalidProductException;
import ee.taltech.backend.exception.ProductNotFoundException;
import ee.taltech.backend.model.Product;
import ee.taltech.backend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("products")
@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> getProducts(@RequestParam(value = "name", required = false) String name) {
        return productService.findAll(name);
    }

    @GetMapping("{id}")
    public Product getProductById(@PathVariable Long id) throws ProductNotFoundException {
        return productService.findById(id);
    }

    @PostMapping
    public Product saveProduct(@RequestBody Product product) throws InvalidProductException {
        return productService.save(product);
    }

    @PutMapping("{id}")
    public Product updateProduct(@RequestBody Product product, @PathVariable Long id) throws InvalidProductException, ProductNotFoundException {
        return productService.update(product, id);
    }

    @DeleteMapping("{id}")
    public void deleteProduct(@PathVariable Long id) throws ProductNotFoundException {
        productService.delete(id);
    }

    @GetMapping("{name}")
    public List<Product> getProductsByName(@PathVariable String name) {
        return productService.findAll(name);
    }


    //todo validation?
    //todo add tests

}
