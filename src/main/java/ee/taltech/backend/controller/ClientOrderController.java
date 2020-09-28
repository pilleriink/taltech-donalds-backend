package ee.taltech.backend.controller;

import ee.taltech.backend.exception.InvalidOrderException;
import ee.taltech.backend.exception.InvalidProductException;
import ee.taltech.backend.model.order.ClientOrder;
import ee.taltech.backend.model.order.OrderProduct;
import ee.taltech.backend.repository.ClientOrderRepository;
import ee.taltech.backend.service.ClientOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RequestMapping("orders")
@RestController
public class ClientOrderController {

    @Autowired
    private ClientOrderService clientOrderService;

    @PostMapping
    public ClientOrder save(@RequestBody ClientOrder clientOrder) throws InvalidOrderException {
        return clientOrderService.save(clientOrder);
    }
}
