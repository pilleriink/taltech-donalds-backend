package ee.taltech.backend.service;

import ee.taltech.backend.exception.CategoryNotFoundException;
import ee.taltech.backend.exception.MealNotFoundException;
import ee.taltech.backend.model.category.Category;
import ee.taltech.backend.model.category.CategoryDto;
import ee.taltech.backend.model.meal.Meal;
import ee.taltech.backend.model.meal.MealDto;
import ee.taltech.backend.model.product.Product;
import ee.taltech.backend.model.product.ProductDto;
import ee.taltech.backend.repository.MealRepository;
import ee.taltech.backend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MealService {

    @Autowired
    MealRepository mealRepository;

    @Autowired
    ProductRepository productRepository;

    public List<Meal> findAll() {return mealRepository.findAll();}

    public Meal findById(Long id) throws MealNotFoundException {
        return mealRepository.findById(id)
                .orElseThrow(MealNotFoundException::new);
    }

    public MealDto save(MealDto mealDto) {
        Meal meal = new Meal();
        meal.setName(meal.getName());
        meal.setProducts(new ArrayList<>()); //needs to have products, not empty list
        Meal save = mealRepository.save(meal);
        return new MealDto(save);
    }

    public void delete(Long id) throws MealNotFoundException {
        Meal meal = findById(id);
        mealRepository.delete(meal);
    }

    public MealDto update(MealDto mealDto, Long id) throws MealNotFoundException {
        Meal meal = findById(id);
        List<ProductDto> productDtos = mealDto.getProducts();
        List<Product> products = new ArrayList<>();
        meal.setProducts(new ArrayList<>());
        for (ProductDto productDto : productDtos) {
            Product product = productRepository.findById(productDto.getId()).orElseThrow();
            products.add(product);
        }
        meal.setProducts(products);
        Meal save = mealRepository.save(meal);
        return new MealDto(save);
    }
}
