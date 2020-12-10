package ee.taltech.backend.model.order;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class OrderProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double price;
    private String removedIngredients;
    @ManyToOne
    @JoinColumn(name = "client_order_id", nullable = false)
    private ClientOrder clientOrder;
    public OrderProduct(String name, Double price, String removedIngredients, ClientOrder clientOrder) {
        this.name = name;
        this.price = price;
        this.removedIngredients = removedIngredients;
        this.clientOrder = clientOrder;
    }
}
