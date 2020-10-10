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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double price;
    @ManyToOne(cascade = CascadeType.ALL)
    private ClientOrder clientOrder;
    @OneToMany(cascade = CascadeType.ALL)
    private List<OrderProduct> orderProducts;
}
