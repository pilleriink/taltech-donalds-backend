package ee.taltech.backend.controller;

import ee.taltech.backend.exception.InvalidOrderException;
import ee.taltech.backend.model.order.ClientOrder;
import ee.taltech.backend.service.order.ClientOrderService;
import ee.taltech.backend.service.EmailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("orders")
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ClientOrderController {

    @Autowired
    private ClientOrderService clientOrderService;

    @PostMapping
    public ClientOrder save(@RequestBody ClientOrder clientOrder) throws InvalidOrderException {
        ClientOrder clientOrder1 = clientOrderService.save(clientOrder);
        return clientOrder1;
    }
}
