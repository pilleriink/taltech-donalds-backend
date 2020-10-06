package ee.taltech.backend;

import ee.taltech.backend.exception.CategoryNotFoundException;
import ee.taltech.backend.exception.InvalidOrderException;
import ee.taltech.backend.exception.ProductNotFoundException;
import ee.taltech.backend.model.location.Location;
import ee.taltech.backend.model.order.ClientOrder;
import ee.taltech.backend.service.*;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ServiceTest {

    @Autowired
    ProductService productService;
    @Autowired
    CategoryService categoryService;

    @Test
    public void productServiceGetProductById() throws ProductNotFoundException {
        assertEquals(productService.findById(7L).getName(), "Naked burger");
    }

    @Test void categoryServiceFindAllNotEmpty() {
        assertTrue(categoryService.findAll().size() > 0);
    }

    @Test void categoryServiceFindByIdCorrectProduct() throws CategoryNotFoundException {
        assertEquals(categoryService.findById(3L).getId(), 3L);
    }

}
