package ee.taltech.backend.controller;

import ee.taltech.backend.exception.InvalidOrderException;
import ee.taltech.backend.exception.InvalidOrderProductException;
import ee.taltech.backend.model.order.ClientOrder;
import ee.taltech.backend.model.order.OrderProduct;
import ee.taltech.backend.service.order.ClientOrderService;
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

    @PostMapping
    public ClientOrder save(@RequestBody ClientOrder clientOrderData) throws InvalidOrderException, InvalidOrderProductException {
        ClientOrder clientOrder = clientOrderService.save(clientOrderData);
        List<OrderProduct> order_products = clientOrder.getOrderProducts();

        for (OrderProduct orderProduct : order_products) {
            OrderProduct order_product = new OrderProduct(orderProduct.getName(), orderProduct.getPrice(), orderProduct.getRemovedIngredients(), clientOrder);
            orderProductService.save(order_product);
        }
        return clientOrder;
    }
}
