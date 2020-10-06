package ee.taltech.backend;

import ee.taltech.backend.controller.CategoryController;
import ee.taltech.backend.controller.LocationController;
import ee.taltech.backend.exception.CategoryNotFoundException;
import ee.taltech.backend.exception.ProductNotFoundException;
import ee.taltech.backend.model.category.Category;
import ee.taltech.backend.model.category.CategoryDto;
import ee.taltech.backend.model.category.CategoryMinifiedDto;
import ee.taltech.backend.model.location.Location;
import ee.taltech.backend.model.product.Product;
import ee.taltech.backend.repository.CategoryRepository;
import ee.taltech.backend.repository.LocationRepository;
import ee.taltech.backend.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    private LocationController locationController;

    @Autowired
    private CategoryController categoryController;

    @Test
    void locationControllerGetResponse() throws Exception {
        ResponseEntity<String> entity = testRestTemplate.getForEntity("/locations", String.class);
        assertEquals(HttpStatus.OK, entity.getStatusCode());
    }

    @Test
    void locationControllerGetLocations() {
        assertEquals(locationController.getLocations().size(), 2);
    }

    @Test void categoryControllerFindAll() throws ProductNotFoundException {
        assertEquals(categoryController.findAll().get(0).getClass(), CategoryMinifiedDto.class);
    }


}
