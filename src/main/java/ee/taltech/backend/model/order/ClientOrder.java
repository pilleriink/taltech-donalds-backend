package ee.taltech.backend.model.order;

import ee.taltech.backend.model.location.Location;
import ee.taltech.backend.model.product.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class ClientOrder {

    @Id
    @GeneratedValue
    private Long id;
    private String email;
    private Double price;
    @ManyToOne
    private Location location;
    @OneToMany(mappedBy = "clientOrder", cascade = CascadeType.ALL)
    private List<OrderProduct> orderProducts = new ArrayList<>();
    @OneToMany(mappedBy = "clientOrder", cascade = CascadeType.ALL)
    private List<OrderMeal> orderMeals = new ArrayList<>();

}
