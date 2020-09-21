package ee.taltech.backend.controller;

import ee.taltech.backend.exception.InvalidProductException;
import ee.taltech.backend.exception.ProductNotFoundException;
import ee.taltech.backend.model.category.Category;
import ee.taltech.backend.model.category.CategoryDto;
import ee.taltech.backend.model.category.CategoryMinifiedDto;
import ee.taltech.backend.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RequestMapping("categories")
@RestController
public class CategoryController {

    @Autowired
    CategoryService categoryService;


    @GetMapping
    public List<CategoryMinifiedDto> findAll() throws ProductNotFoundException {
        return categoryService.findAll().stream().map(CategoryMinifiedDto::new).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public CategoryDto getCategoryById(@PathVariable Long id) throws ProductNotFoundException {
        return new CategoryDto(categoryService.findById(id));
    }

    @PostMapping
    public Category saveCategory(@RequestBody Category category) throws InvalidProductException {
        return categoryService.save(category);
    }

    @PutMapping("/{id}")
    public Category updateProduct(@RequestBody Category category, @PathVariable Long id) throws InvalidProductException, ProductNotFoundException {
        return categoryService.update(category, id);
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Long id) throws ProductNotFoundException {
        categoryService.delete(id);
    }

}
