package ee.taltech.backend.service;

import ee.taltech.backend.exception.InvalidOrderException;
import ee.taltech.backend.exception.InvalidProductException;
import ee.taltech.backend.model.order.ClientOrder;
import ee.taltech.backend.model.order.OrderProduct;
import ee.taltech.backend.repository.ClientOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientOrderService {

    @Autowired
    private ClientOrderRepository clientOrderRepository;

    public ClientOrder save(ClientOrder clientOrder) throws InvalidOrderException {
        if (clientOrder.getEmail() == null
                || clientOrder.getLocation() == null
                || clientOrder.getPhoneNumber() == null
                || clientOrder.getPrice() == null
                || clientOrder.getOrderProducts() == null) {
            throw new InvalidOrderException("Invalid order");
        }
        return clientOrderRepository.save(clientOrder);
    }

}
