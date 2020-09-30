package ee.taltech.backend.model.order;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class OrderProduct {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Double price;
    private String removedIngredients;
    @ManyToOne
    private ClientOrder clientOrder;
}
