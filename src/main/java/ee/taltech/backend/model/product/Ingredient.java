package ee.taltech.backend.model.product;

import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
public class Ingredient {

    @NonNull
    private String name;
    private Boolean removed = false;
}
