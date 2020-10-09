package ee.taltech.backend.repository;

import ee.taltech.backend.model.order.OrderMeal;
import ee.taltech.backend.model.order.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderMealRepository extends JpaRepository<OrderMeal, Long> {
}
