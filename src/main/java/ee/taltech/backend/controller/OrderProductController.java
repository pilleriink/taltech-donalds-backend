package ee.taltech.backend.controller;

import ee.taltech.backend.exception.InvalidOrderProductException;
import ee.taltech.backend.exception.InvalidProductException;
import ee.taltech.backend.model.order.OrderProduct;
import ee.taltech.backend.model.product.Product;
import ee.taltech.backend.service.EmailServiceImpl;
import ee.taltech.backend.service.OrderProductService;
import ee.taltech.backend.service.ProductService;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RequestMapping("orderProducts")
@RestController
public class OrderProductController {

    @Autowired
    private OrderProductService orderProductService;

    @PostMapping
    public OrderProduct save(@RequestBody OrderProduct orderProduct) throws InvalidOrderProductException {
        return orderProductService.save(orderProduct);
    }

}
