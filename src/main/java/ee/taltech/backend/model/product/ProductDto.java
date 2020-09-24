package ee.taltech.backend.model.product;

import ee.taltech.backend.model.category.Category;
import ee.taltech.backend.model.category.CategoryMinifiedDto;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class ProductDto {

    private Long id;
    private String name;
    private Double price;
    private String image;
    private String description;
    private List<Ingredient> removableIngredients;
    private CategoryMinifiedDto category;

    public ProductDto(Product product) {
        id = product.getId();
        name = product.getName();
        price = product.getPrice();
        image = product.getImage();
        description = product.getDescription();
        removableIngredients = Arrays.stream(product.getRemovableIngredients().split(", "))
                .map(Ingredient::new).collect(Collectors.toList());
        category = new CategoryMinifiedDto(product.getCategory());
    }
}
