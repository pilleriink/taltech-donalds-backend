package ee.taltech.backend.controller;

import ee.taltech.backend.exception.InvalidOrderException;
import ee.taltech.backend.model.order.ClientOrder;
import ee.taltech.backend.service.order.ClientOrderService;
import ee.taltech.backend.service.order.EmailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("orders")
@RestController
public class ClientOrderController {

    @Autowired
    private ClientOrderService clientOrderService;

    @Autowired
    private EmailServiceImpl emailService;

    @PostMapping
    public ClientOrder save(@RequestBody ClientOrder clientOrder) throws InvalidOrderException {
        ClientOrder clientOrder1 = clientOrderService.save(clientOrder);
        emailService.sendSimpleMessage(clientOrder1);
        return clientOrder1;
    }
}
