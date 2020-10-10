package ee.taltech.backend.model.order;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.criterion.Order;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class OrderProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double price;
    private String removedIngredients;
    @ManyToOne(cascade = CascadeType.ALL)
    private ClientOrder clientOrder;
    @ManyToOne(cascade = CascadeType.ALL)
    private OrderMeal meal;
}
