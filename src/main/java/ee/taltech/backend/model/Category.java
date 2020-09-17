package ee.taltech.backend.model;

import javax.persistence.OneToMany;
import java.util.List;

public class Category {

    @OneToMany
    private List<Product> products;
}
