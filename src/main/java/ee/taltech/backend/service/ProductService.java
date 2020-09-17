package ee.taltech.backend.service;

import ee.taltech.backend.model.Product;
import ee.taltech.backend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product save(Product product) {
        if (product.getName() == null || product.getPrice() == null) {

        }
        return productRepository.save(product);
    }

}
