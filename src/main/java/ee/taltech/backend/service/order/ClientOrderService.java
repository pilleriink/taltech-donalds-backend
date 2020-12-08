package ee.taltech.backend.service.order;

import ee.taltech.backend.exception.InvalidOrderException;
import ee.taltech.backend.exception.InvalidProductException;
import ee.taltech.backend.exception.UserException;
import ee.taltech.backend.model.order.ClientOrder;
import ee.taltech.backend.model.order.OrderProduct;
import ee.taltech.backend.repository.ClientOrderRepository;
import ee.taltech.backend.service.users.UserService;
import ee.taltech.backend.service.EmailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientOrderService {

    @Autowired
    private ClientOrderRepository clientOrderRepository;
    private UserService userService;
    private EmailServiceImpl emailService;

    public ClientOrder save(ClientOrder clientOrder) throws InvalidOrderException {
        if (clientOrder.getEmail() == null
                || clientOrder.getLocation() == null
                || clientOrder.getPrice() == null
                || clientOrder.getOrderProducts() == null) {
            throw new InvalidOrderException("Invalid order");
        }
        if (userService.getCurrentUser() == null) {
            throw new UserException("Not logged in");
        }
        emailService.sendSimpleMessageOrder(clientOrder);
        return clientOrderRepository.save(clientOrder);
    }

}
