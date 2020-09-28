package ee.taltech.backend.model.order;

import ee.taltech.backend.model.location.Location;
import ee.taltech.backend.model.product.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class ClientOrder {

    @Id
    @GeneratedValue
    private Long id;
    private String number;
    private String email;
    private Double price;
    private String location;
    @OneToMany(mappedBy = "clientOrder")
    private List<OrderProduct> orderProducts;

}
