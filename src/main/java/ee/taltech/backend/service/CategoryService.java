package ee.taltech.backend.service;

import ee.taltech.backend.exception.CategoryNotFoundException;
import ee.taltech.backend.exception.InvalidProductException;
import ee.taltech.backend.exception.ProductNotFoundException;
import ee.taltech.backend.model.category.Category;
import ee.taltech.backend.model.category.CategoryDto;
import ee.taltech.backend.model.meal.Meal;
import ee.taltech.backend.model.product.Product;
import ee.taltech.backend.model.product.ProductDto;
import ee.taltech.backend.repository.CategoryRepository;
import ee.taltech.backend.repository.MealRepository;
import ee.taltech.backend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    ProductService productService;

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Category findById(Long id) throws CategoryNotFoundException {
        return categoryRepository.findById(id)
                .orElseThrow(CategoryNotFoundException::new);
    }

    public CategoryDto save(CategoryDto categoryDto) {
        Category category = new Category();
        category.setName(categoryDto.getName());
        category.setProducts(new ArrayList<>());
        Category save = categoryRepository.save(category);
        return new CategoryDto(save);
    }

    public void delete(Long id) throws CategoryNotFoundException, ProductNotFoundException {
        Category category = findById(id);
        List<Product> products = productRepository.findAllByCategory(category);
        for (Product product : products) {
            category.getProducts().remove(product);
            categoryRepository.save(category);
            productService.delete(product.getId());
        }
        categoryRepository.delete(category);
    }

}
