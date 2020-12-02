package ee.taltech.backend.service;

import ee.taltech.backend.exception.ProductNotFoundException;
import ee.taltech.backend.model.category.Category;
import ee.taltech.backend.model.product.Product;
import ee.taltech.backend.model.product.ProductDto;
import ee.taltech.backend.repository.CategoryRepository;
import ee.taltech.backend.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findById(Long id) throws ProductNotFoundException {
        return productRepository.findById(id)
                .orElseThrow(ProductNotFoundException::new);
    }

    public ProductDto save(ProductDto productDto) {
        Product product = new Product();
        product.setName(productDto.getName());
        product.setMeals(new ArrayList<>());
        product.setPrice(productDto.getPrice());
        product.setRemovableIngredients(productDto.getRemovableIngredients());
        product.setPrice(productDto.getPrice());
        product.setImage(productDto.getImage());
        product.setDescription(productDto.getDescription());
        System.out.println(productDto.getCategory());
        Category category = categoryRepository.findByName(productDto.getCategory().getName());
        product.setCategory(category);
        product.setComments(new ArrayList<>());
        Product save = productRepository.save(product);
        return new ProductDto(save);
    }

}
