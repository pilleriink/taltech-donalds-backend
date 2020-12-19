package ee.taltech.backend.model.order;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @ManyToOne
    @JsonIgnore
    private ClientOrder clientOrder;
    @OneToMany(cascade = CascadeType.ALL)
    private List<OrderProduct> orderProducts;
}
