package ee.taltech.backend.service.order;

import ee.taltech.backend.exception.InvalidOrderException;
import ee.taltech.backend.exception.UserException;
import ee.taltech.backend.model.order.ClientOrder;
import ee.taltech.backend.model.order.ClientOrderDto;
import ee.taltech.backend.model.user.User;
import ee.taltech.backend.repository.ClientOrderRepository;
import ee.taltech.backend.service.EmailServiceImpl;
import ee.taltech.backend.service.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientOrderService {

    @Autowired
    private ClientOrderRepository clientOrderRepository;
    @Autowired
    private UserService userService;
    @Autowired
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

    public List<ClientOrderDto> findByUser(Long userId) {
        User user = userService.findById(userId);
        List<ClientOrder> client_orders = clientOrderRepository.findByUser(user);
        List<ClientOrderDto> client_orders_dto = new ArrayList<>();
        for(ClientOrder client_order : client_orders) {
            ClientOrderDto client_order_dto = new ClientOrderDto(client_order);
            client_orders_dto.add(client_order_dto);
        }
        return client_orders_dto;
    }
}
