package ee.taltech.backend.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Product {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Double price;
    private String image;
    private String description;
    private String removableIngredients;
}
