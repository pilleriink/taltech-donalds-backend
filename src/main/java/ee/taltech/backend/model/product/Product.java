package ee.taltech.backend.model.product;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import ee.taltech.backend.model.category.Category;
import ee.taltech.backend.model.comment.Comment;
import ee.taltech.backend.model.meal.Meal;
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
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double price;
    private String image;
    private String description;
    private String removableIngredients;
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Comment> comments = new ArrayList<>();
    @ManyToOne
    private Category category;
    @ManyToMany
    private List<Meal> meals = new ArrayList<>();

    public void addMeal(Meal meal) {meals.add(meal);}
}
