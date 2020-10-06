package ee.taltech.backend.service;

import ee.taltech.backend.exception.CategoryNotFoundException;
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

    public Category findById(Long id) throws CategoryNotFoundException {
        return categoryRepository.findById(id)
                .orElseThrow(CategoryNotFoundException::new);
    }


}
