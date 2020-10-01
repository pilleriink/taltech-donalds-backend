package ee.taltech.backend.model.comment;

import ee.taltech.backend.model.product.Product;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Comment {

    @Id
    @GeneratedValue
    private Long id;
    //private String username;
    private String comment;
    @ManyToOne
    private Product product;

    public Comment(long id, String comment, Product product) {
        this.id = id;
        this.comment = comment;
        this.product = product;
    }
}
