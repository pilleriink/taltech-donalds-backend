package ee.taltech.backend.model.meal;

import ee.taltech.backend.model.product.ProductDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class MealMinifiedDto {

    private Long id;
    private String name;
    private Double price;
    private String image;
    private String description;
    private List<ProductDto> products;

    public MealMinifiedDto(Meal meal) {
        id = meal.getId();
        name = meal.getName();
        price = meal.getPrice();
        image = meal.getImage();
        description = meal.getDescription();
    }
}
