package ee.taltech.backend.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Product {

    public enum Type{ WINE, BEER, HARD_LIQUOR }

    @Id
    @GeneratedValue
    private long id;
    private String name;
    private double price;
    private Type type;
    private BigDecimal volume;
    private double alcoholByVolume;

}
