package ee.taltech.backend.controller;

import ee.taltech.backend.exception.InvalidOrderException;
import ee.taltech.backend.exception.InvalidOrderProductException;
import ee.taltech.backend.model.order.ClientOrder;
import ee.taltech.backend.model.order.ClientOrderDto;
import ee.taltech.backend.model.order.OrderMeal;
import ee.taltech.backend.model.order.OrderProduct;
import ee.taltech.backend.service.order.ClientOrderService;
import ee.taltech.backend.service.order.OrderMealService;
import ee.taltech.backend.service.order.OrderProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("orders")
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ClientOrderController {

    @Autowired
    private ClientOrderService clientOrderService;
    @Autowired
    private OrderProductService orderProductService;
    @Autowired
    private OrderMealService orderMealService;

    @GetMapping("/user/{id}")
    public List<ClientOrderDto> findByUser(@PathVariable Long id) {
        return clientOrderService.findByUser(id);
    }

    @PostMapping
    public ClientOrder save(@RequestBody ClientOrder clientOrderData) throws InvalidOrderException, InvalidOrderProductException {
        return clientOrderService.save(clientOrderData);
    }
}
