package ee.taltech.backend.service;

import ee.taltech.backend.exception.MealNotFoundException;
import ee.taltech.backend.model.meal.Meal;
import ee.taltech.backend.repository.MealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MealService {

    @Autowired
    MealRepository mealRepository;

    public List<Meal> findAll() {return mealRepository.findAll();}

    public Meal findById(Long id) throws MealNotFoundException {
        return mealRepository.findById(id)
                .orElseThrow(MealNotFoundException::new);
    }
}
