package ee.taltech.backend.model.category;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CategoryMinifiedDto {

    private Long id;
    private String name;

    public CategoryMinifiedDto(Category category) {
        id = category.getId();
        name = category.getName();
    }
}
