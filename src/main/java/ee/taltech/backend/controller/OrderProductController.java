package ee.taltech.backend.controller;

import ee.taltech.backend.exception.InvalidOrderProductException;
import ee.taltech.backend.model.order.OrderProduct;
import ee.taltech.backend.service.order.OrderProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("order/products")
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class OrderProductController {

    @Autowired
    private OrderProductService orderProductService;

    @PostMapping
    public OrderProduct save(@RequestBody OrderProduct orderProduct) throws InvalidOrderProductException {
        return orderProductService.save(orderProduct);
    }

}
