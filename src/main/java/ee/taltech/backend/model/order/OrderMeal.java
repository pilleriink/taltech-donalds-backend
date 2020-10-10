package ee.taltech.backend.model.order;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class OrderMeal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    private Long id;
    private String name;
    private Double price;
    @ManyToOne
    private ClientOrder clientOrder;
    @OneToMany
    private List<OrderProduct> orderProducts;
}
