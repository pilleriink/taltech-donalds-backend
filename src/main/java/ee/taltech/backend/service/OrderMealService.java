package ee.taltech.backend.service;

import ee.taltech.backend.exception.InvalidOrderMealException;
import ee.taltech.backend.exception.InvalidOrderProductException;
import ee.taltech.backend.model.order.OrderMeal;
import ee.taltech.backend.model.order.OrderProduct;
import ee.taltech.backend.repository.OrderMealRepository;
import ee.taltech.backend.repository.OrderProductRepository;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderMealService {

    @Autowired
    private OrderMealRepository orderMealRepository;

    public OrderMeal save(OrderMeal orderMeal) throws InvalidOrderMealException {
        if (orderMeal.getOrderProducts() == null
                || orderMeal.getClientOrder() == null) {
            throw new InvalidOrderMealException("Invalid product");
        }
        if (orderMeal.getId() != null) {
            throw new InvalidOrderMealException("Product already exists");
        }
        return orderMealRepository.save(orderMeal);
    }
}
