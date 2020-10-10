package ee.taltech.backend;

import ee.taltech.backend.controller.*;
import ee.taltech.backend.exception.*;
import ee.taltech.backend.model.category.CategoryMinifiedDto;
import ee.taltech.backend.model.order.OrderMeal;
import ee.taltech.backend.model.order.OrderProduct;
import ee.taltech.backend.model.product.ProductDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

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
    @Autowired
    private OrderMealController orderMealController;
    @Autowired
    private AdvertisementController advertisementController;

    @Test
    void categoryControllerGetResponse() {
        ResponseEntity<String> entity = testRestTemplate.getForEntity("/categories/1", String.class);
        assertEquals(HttpStatus.OK, entity.getStatusCode());
    }

    @Test
    void productControllerGetResponse() {
        ResponseEntity<String> entity = testRestTemplate.getForEntity("/products/1", String.class);
        assertEquals(HttpStatus.OK, entity.getStatusCode());

    }

    @Test
    void mealControllerGetResponseFindAll() {
        ResponseEntity<String> entity = testRestTemplate.getForEntity("/meals", String.class);
        assertEquals(HttpStatus.OK, entity.getStatusCode());
    }

    @Test
    void mealControllerGetResponseById() {
        ResponseEntity<String> entity = testRestTemplate.getForEntity("/meals/1", String.class);
        assertEquals(HttpStatus.OK, entity.getStatusCode());
    }

    @Test
    void locationControllerGetResponse() {
        ResponseEntity<String> entity = testRestTemplate.getForEntity("/locations", String.class);
        assertEquals(HttpStatus.OK, entity.getStatusCode());
    }

    @Test
    void advertisementControllerGetResponse() {
        ResponseEntity<String> entity = testRestTemplate.getForEntity("/ads", String.class);
        assertEquals(HttpStatus.OK, entity.getStatusCode());
    }

    @Test
    void advertisementControllerGetAds() {
        assertTrue(advertisementController.findAll().size() > 0);
    }

    @Test
    void locationControllerGetLocations() {
        assertTrue(locationController.getLocations().size() > 0);
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

    @Test
    void orderMealCategoryThrowsExceptionWhenMealIsEmpty() {
        assertThrows(InvalidOrderMealException.class, () -> {
            orderMealController.save(new OrderMeal());
        });
    }

}
