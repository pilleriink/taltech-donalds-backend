package ee.taltech.backend.model.category;

import ee.taltech.backend.model.product.ProductDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class CategoryDto {

    private Long id;
    private String name;
    private List<ProductDto> products;

    public CategoryDto(Category category) {
        id = category.getId();
        name = category.getName();
        products = category.getProducts().stream().map(ProductDto::new).collect(Collectors.toList());
    }

}
