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
    private Long productId;

    public Comment(String comment, Long productId) {
        this.comment = comment;
        this.productId = productId;
    }
}
