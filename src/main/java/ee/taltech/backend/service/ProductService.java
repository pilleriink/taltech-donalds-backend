package ee.taltech.backend.service;

import ee.taltech.backend.exception.InvalidProductException;
import ee.taltech.backend.exception.ProductNotFoundException;
import ee.taltech.backend.model.product.Product;
import ee.taltech.backend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAllByName(String name) {
        return productRepository.findByNameContains(name);
    }

    public Product save(Product product) throws InvalidProductException {
        if (product.getName() == null
                || product.getPrice() == null
                || product.getImage() == null
                || product.getDescription() == null
                || product.getRemovableIngredients() == null) {
            throw new InvalidProductException("Invalid product");
        }
        if (product.getId() != null) {
            throw new InvalidProductException("Product already exists");
        }
        return productRepository.save(product);
    }

    public Product findById(Long id) throws ProductNotFoundException {
        return productRepository.findById(id)
                .orElseThrow(ProductNotFoundException::new);
    }

    public Product update(Product product, Long id) throws InvalidProductException, ProductNotFoundException {
        if (product.getName() == null
                || product.getPrice() == null
                || product.getImage() == null
                || product.getDescription() == null
                || product.getRemovableIngredients() == null) {
            throw new InvalidProductException("Invalid product");
        }
        Product databaseProduct = findById(id);
        databaseProduct.setImage(product.getImage());
        databaseProduct.setName(product.getName());
        databaseProduct.setPrice(product.getPrice());
        return productRepository.save(databaseProduct);
    }

    public void delete(Long id) throws ProductNotFoundException {
        Product databaseProduct = findById(id);
        productRepository.delete(databaseProduct);
    }

}
