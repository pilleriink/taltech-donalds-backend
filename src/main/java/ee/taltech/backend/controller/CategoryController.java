package ee.taltech.backend.controller;

import ee.taltech.backend.exception.CategoryNotFoundException;
import ee.taltech.backend.exception.ProductNotFoundException;
import ee.taltech.backend.model.category.CategoryDto;
import ee.taltech.backend.model.category.CategoryMinifiedDto;
import ee.taltech.backend.security.Roles;
import ee.taltech.backend.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("categories")
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping
    public List<CategoryMinifiedDto> findAll() {
        return categoryService.findAll().stream().map(CategoryMinifiedDto::new).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public CategoryDto getCategoryById(@PathVariable Long id) throws CategoryNotFoundException {
        return new CategoryDto(categoryService.findById(id));
    }

    @Secured(Roles.ADMIN)
    @PostMapping
    public CategoryDto save(@RequestBody CategoryDto categoryDto){
        return categoryService.save(categoryDto);
    }

    @Secured(Roles.ADMIN)
    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) throws CategoryNotFoundException, ProductNotFoundException {
        categoryService.delete(id);
    }
}
