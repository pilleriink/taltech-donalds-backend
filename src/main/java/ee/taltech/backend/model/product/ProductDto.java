package ee.taltech.backend.model.product;

import ee.taltech.backend.model.category.CategoryMinifiedDto;
import ee.taltech.backend.model.comment.CommentDto;
import ee.taltech.backend.model.meal.MealMinifiedDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class ProductDto {

    private Long id;
    private String name;
    private Double price;
    private String image;
    private String description;
    private String removableIngredients;
    private List<CommentDto> comments;
    private CategoryMinifiedDto category;
    private List<MealMinifiedDto> meals;

    public ProductDto(Product product) {
        id = product.getId();
        name = product.getName();
        price = product.getPrice();
        image = product.getImage();
        comments = product.getComments().stream().map(CommentDto::new).collect(Collectors.toList());
        description = product.getDescription();
        removableIngredients = product.getRemovableIngredients();
        category = new CategoryMinifiedDto(product.getCategory());
        meals = product.getMeals().stream().map(MealMinifiedDto::new).collect(Collectors.toList());
    }
}
