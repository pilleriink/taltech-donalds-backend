package ee.taltech.backend;

import ee.taltech.backend.controller.*;
import ee.taltech.backend.exception.*;
import ee.taltech.backend.model.category.Category;
import ee.taltech.backend.model.category.CategoryDto;
import ee.taltech.backend.model.category.CategoryMinifiedDto;
import ee.taltech.backend.model.comment.Comment;
import ee.taltech.backend.model.comment.CommentRequest;
import ee.taltech.backend.model.location.Location;
import ee.taltech.backend.model.order.ClientOrder;
import ee.taltech.backend.model.order.OrderProduct;
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

    @Autowired
    private OrderProductController orderProductController;

    @Autowired
    private ProductController productController;

    @Test
    void locationControllerGetResponse() {
        ResponseEntity<String> entity = testRestTemplate.getForEntity("/locations", String.class);
        assertEquals(HttpStatus.OK, entity.getStatusCode());
    }

    @Test
    void locationControllerGetLocations() {
        assertEquals(locationController.getLocations().size(), 2);
    }

    @Test void categoryControllerFindAll() {
        assertEquals(categoryController.findAll().get(0).getClass(), CategoryMinifiedDto.class);
    }

    @Test
    void orderProductControllerThrowsExceptionWhenProductIsEmpty() {
        assertThrows(InvalidOrderProductException.class, () -> {
            orderProductController.save(new OrderProduct());
        });
    }

    @Test
    void productControllerThrowsExceptionWhenProductNotInDB() {
        assertThrows(ProductNotFoundException.class, () -> {
           productController.getProductById(999L);
        });
    }

}
