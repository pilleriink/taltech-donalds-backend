package ee.taltech.backend.service;

import ee.taltech.backend.exception.InvalidProductException;
import ee.taltech.backend.exception.ProductNotFoundException;
import ee.taltech.backend.model.category.Category;
import ee.taltech.backend.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Category save(Category category) throws InvalidProductException {
        if (category.getName() == null) {
            throw new InvalidProductException("Invalid product");
        }
        if (category.getId() != null) {
            throw new InvalidProductException("Product already exists");
        }
        return categoryRepository.save(category);
    }

    public Category findById(Long id) throws ProductNotFoundException {
        return categoryRepository.findById(id)
                .orElseThrow(ProductNotFoundException::new);
    }

    public Category update(Category category, Long id) throws InvalidProductException, ProductNotFoundException {
        if (category.getName() == null) {
            throw new InvalidProductException("Invalid product");
        }
        Category databaseCategory = findById(id);
        databaseCategory.setName(category.getName());
        return categoryRepository.save(databaseCategory);
    }

    public void delete(Long id) throws ProductNotFoundException {
        Category databaseCategory = findById(id);
        categoryRepository.delete(databaseCategory);
    }
}
