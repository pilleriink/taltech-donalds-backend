package ee.taltech.backend;
import ee.taltech.backend.model.category.Category;
import ee.taltech.backend.model.location.Location;
import ee.taltech.backend.model.product.Product;
import ee.taltech.backend.repository.CategoryRepository;
import ee.taltech.backend.repository.CommentRepository;
import ee.taltech.backend.repository.LocationRepository;
import ee.taltech.backend.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RepositoryTest {

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private LocationRepository locationRepository;

    @Test void addCategoryToRepository() {
        Category category = new Category();
        category.setProducts(new ArrayList<>());
        category.setName("Meal");
        categoryRepository.save(category);
        assertNotNull(categoryRepository.findByName("Meal").getId());
    }

    @Test void addLocationToRepository() {
        Location location = new Location();
        location.setAddress("tehnika");
        location.setLat(23D);
        location.setLon(40D);
        location.setName("TTÜ");
        locationRepository.save(location);
        assertEquals(locationRepository.findAll().get(locationRepository.findAll().size() - 1).getName(), "TTÜ");

    }
}
