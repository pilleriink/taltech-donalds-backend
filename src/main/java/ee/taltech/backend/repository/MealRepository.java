package ee.taltech.backend.repository;

import ee.taltech.backend.model.meal.Meal;
import ee.taltech.backend.model.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MealRepository extends JpaRepository<Meal, Long> {

    List<Meal> findAllByProductsContains(Product product);
}
