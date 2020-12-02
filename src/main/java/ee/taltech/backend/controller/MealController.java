package ee.taltech.backend.controller;

import ee.taltech.backend.exception.CategoryNotFoundException;
import ee.taltech.backend.exception.MealNotFoundException;
import ee.taltech.backend.model.category.CategoryDto;
import ee.taltech.backend.model.category.CategoryMinifiedDto;
import ee.taltech.backend.model.meal.Meal;
import ee.taltech.backend.model.meal.MealDto;
import ee.taltech.backend.model.meal.MealMinifiedDto;
import ee.taltech.backend.security.Roles;
import ee.taltech.backend.service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("meals")
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MealController {

    @Autowired
    private MealService mealService;

    @GetMapping
    public List<MealDto> findAll() {
        return mealService.findAll().stream().map(MealDto::new).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public MealDto getCategoryById(@PathVariable Long id) throws MealNotFoundException {
        return new MealDto(mealService.findById(id));
    }

    @Secured(Roles.ADMIN)
    @PostMapping
    public MealDto save(@RequestBody MealDto mealDto){
        return mealService.save(mealDto);
    }

    @Secured(Roles.ADMIN)
    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) throws MealNotFoundException {
        mealService.delete(id);
    }

    @Secured(Roles.ADMIN)
    @PutMapping("{id}")
    public MealDto update(@RequestBody MealDto mealDto, @PathVariable Long id) throws MealNotFoundException {
        return mealService.update(mealDto, id);
    }
}
