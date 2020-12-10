package ee.taltech.backend.service;

import ee.taltech.backend.exception.MealNotFoundException;
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
        meal.setName(mealDto.getName());
        List<ProductDto> productDtos = mealDto.getProducts();
        List<Product> products = new ArrayList<>();
        for (ProductDto productDto : productDtos) {
            Product product = productRepository.findById(productDto.getId()).orElseThrow();
            products.add(product);
        }
        meal.setProducts(products);
        meal.setPrice(mealDto.getPrice());
        meal.setDescription(mealDto.getDescription());
        meal.setImage(mealDto.getImage());
        Meal save = mealRepository.save(meal);
        return new MealDto(save);
    }

    public void delete(Long id) throws MealNotFoundException {
        Meal meal = findById(id);
        mealRepository.delete(meal);
    }

}
