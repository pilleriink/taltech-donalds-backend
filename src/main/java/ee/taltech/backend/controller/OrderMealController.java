package ee.taltech.backend.controller;

import ee.taltech.backend.exception.InvalidOrderMealException;
import ee.taltech.backend.model.order.OrderMeal;
import ee.taltech.backend.service.order.OrderMealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("order/meals")
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class OrderMealController {

    @Autowired
    private OrderMealService orderMealService;

    @PostMapping
    public OrderMeal save(@RequestBody OrderMeal orderMeal) throws InvalidOrderMealException {
        return orderMealService.save(orderMeal);
    }
}
