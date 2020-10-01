package ee.taltech.backend.model.product;

import ee.taltech.backend.model.comment.Comment;
import ee.taltech.backend.model.category.Category;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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
    @OneToMany(mappedBy = "product")
    private List<Comment> comments = new ArrayList<>();
    @ManyToOne
    private Category category;
}
