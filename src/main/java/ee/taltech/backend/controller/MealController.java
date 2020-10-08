package ee.taltech.backend.controller;

import ee.taltech.backend.exception.CategoryNotFoundException;
import ee.taltech.backend.exception.MealNotFoundException;
import ee.taltech.backend.model.category.CategoryDto;
import ee.taltech.backend.model.category.CategoryMinifiedDto;
import ee.taltech.backend.model.meal.Meal;
import ee.taltech.backend.model.meal.MealDto;
import ee.taltech.backend.model.meal.MealMinifiedDto;
import ee.taltech.backend.service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("meals")
@RestController
public class MealController {

    @Autowired
    private MealService mealService;

    @GetMapping
    public List<MealMinifiedDto> findAll() {
        return mealService.findAll().stream().map(MealMinifiedDto::new).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public MealDto getCategoryById(@PathVariable Long id) throws MealNotFoundException {
        return new MealDto(mealService.findById(id));
    }
}
