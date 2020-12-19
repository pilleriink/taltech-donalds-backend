package ee.taltech.backend.service.order;

import ee.taltech.backend.exception.InvalidOrderException;
import ee.taltech.backend.exception.UserException;
import ee.taltech.backend.model.order.ClientOrder;
import ee.taltech.backend.model.order.ClientOrderDto;
import ee.taltech.backend.model.order.OrderMeal;
import ee.taltech.backend.model.order.OrderProduct;
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
        if (userService.getCurrentUser() == null) {
            throw new UserException("Not logged in");
        }
        ClientOrder clientOrder1 = new ClientOrder();
        clientOrder1.setOrderMeals(new ArrayList<>());
        clientOrder1.setOrderProducts(new ArrayList<>());
        clientOrder1.setUser(clientOrder.getUser());
        clientOrder1.setPrice(clientOrder.getPrice());
        clientOrder1.setLocation(clientOrder.getLocation());
        clientOrder1.setEmail(clientOrder.getEmail());
        clientOrderRepository.save(clientOrder1);
        clientOrder1.setOrderProducts(clientOrder.getOrderProducts());
        clientOrder1.setOrderMeals(clientOrder.getOrderMeals());

        System.out.println(clientOrder1.getId());
        System.out.println(clientOrder1.getId());
        System.out.println(clientOrder1.getId());
        System.out.println(clientOrder1.getId());
        System.out.println(clientOrder1.getId());
        System.out.println(clientOrder1.getId());
        System.out.println(clientOrder1.getId());
        System.out.println(clientOrder1.getId());

        for (OrderMeal orderMeal : clientOrder1.getOrderMeals()) {
            orderMeal.setClientOrder(clientOrder1);
            for (OrderProduct orderProduct : orderMeal.getOrderProducts()) {
                orderProduct.setOrderMeal(orderMeal);
            }
        }

        for (OrderProduct orderProduct : clientOrder1.getOrderProducts()) {
            orderProduct.setClientOrder(clientOrder1);
        }
        ClientOrder clientOrder2 = clientOrderRepository.save(clientOrder1);
        emailService.sendSimpleMessageOrder(clientOrder);
        return clientOrder2;
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
