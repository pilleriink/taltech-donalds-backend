package ee.taltech.backend.model.meal;

import ee.taltech.backend.model.category.Category;
import ee.taltech.backend.model.product.ProductDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.SecondaryTables;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class MealDto {

    private Long id;
    private String name;
    private Double price;
    private String image;
    private String description;
    private List<ProductDto> products;

    public MealDto(Meal meal) {
        id = meal.getId();
        name = meal.getName();
        price = meal.getPrice();
        image = meal.getImage();
        description = meal.getDescription();
        products = meal.getProducts().stream().map(ProductDto::new).collect(Collectors.toList());
    }
}
