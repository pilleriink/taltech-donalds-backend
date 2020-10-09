package ee.taltech.backend.controller;

import ee.taltech.backend.exception.InvalidOrderMealException;
import ee.taltech.backend.model.order.OrderMeal;
import ee.taltech.backend.service.OrderMealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("orderMeals")
@RestController
public class OrderMealController {

    @Autowired
    private OrderMealService orderMealService;

    @PostMapping
    public OrderMeal save(@RequestBody OrderMeal orderMeal) throws InvalidOrderMealException {
        return orderMealService.save(orderMeal);
    }
}
