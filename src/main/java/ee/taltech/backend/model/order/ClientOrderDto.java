package ee.taltech.backend.model.order;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class ClientOrderDto {
    private Long id;
    private String email;
    private Double price;
    private String location;
    private List<String> orderProducts = new ArrayList<>();
    private List<String> orderMeals = new ArrayList<>();

    public ClientOrderDto(ClientOrder clientOrder) {
        id = clientOrder.getId();
        email = clientOrder.getEmail();
        price = clientOrder.getPrice();
        location = clientOrder.getLocation().getName();
        orderProducts = clientOrder.getOrderProducts().stream().map(OrderProduct::getName).collect(Collectors.toList());
        orderMeals = clientOrder.getOrderMeals().stream().map(OrderMeal::getName).collect(Collectors.toList());
    }
}
