package ee.taltech.backend;

import ee.taltech.backend.exception.*;
import ee.taltech.backend.model.comment.Comment;
import ee.taltech.backend.model.comment.CommentRequest;
import ee.taltech.backend.model.location.Location;
import ee.taltech.backend.model.order.ClientOrder;
import ee.taltech.backend.model.order.OrderMeal;
import ee.taltech.backend.model.order.OrderProduct;
import ee.taltech.backend.model.product.Product;
import ee.taltech.backend.service.*;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ServiceTest {

    @Autowired
    ProductService productService;
    @Autowired
    CategoryService categoryService;
    @Autowired
    CommentService commentService;
    @Autowired
    ClientOrderService clientOrderService;
    @Autowired
    OrderProductService orderProductService;
    @Autowired
    EmailServiceImpl emailService;
    @Autowired
    OrderMealService orderMealService;

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

    @Test
    void commentServiceThrowsExceptionWhenEmptyComment() {
        assertThrows(InvalidCommentException.class, () -> {
            commentService.save(new Comment());
        });
    }

    @Test
    void commentServiceThrowsExceptionWhenMissingCommentRequestOrProduct() {
        assertThrows(InvalidCommentException.class, () -> {
           commentService.createNewComment(null, null);
        });
    }

    @Test
    void clientOrderServiceThrowsExceptionWhenEmptyOrder() {
        assertThrows(InvalidOrderException.class, () -> {
           clientOrderService.save(new ClientOrder());
        });
    }

    @Test
    void orderProductServiceThrowsExceptionWhenIdNotNull() {
        OrderProduct orderProduct = new OrderProduct();
        orderProduct.setId(10L);
        assertThrows(InvalidOrderProductException.class, () -> {
            orderProductService.save(orderProduct);
        });
    }

    @Test
    void orderMealServiceThrowExceptionWhenEmptyMeal() {
        OrderMeal orderMeal = new OrderMeal();
        assertThrows(InvalidOrderMealException.class, () -> {
            orderMealService.save(orderMeal);
        });
    }

    @Test
    void orderMealServiceThrowsExceptionWhenIdNotNull() {
        OrderMeal orderMeal = new OrderMeal();
        orderMeal.setId(10L);
        assertThrows(InvalidOrderMealException.class, () -> {
            orderMealService.save(orderMeal);
        });
    }

    @Test
    void emailServiceConstructsCorrectEmail() {
        ClientOrder clientOrder = new ClientOrder();
        clientOrder.setPrice(10D);
        ArrayList<OrderProduct> orderProducts = new ArrayList<>();
        for (int i=0; i<4; i++) {
            OrderProduct orderProduct = new OrderProduct();
            orderProduct.setName(i + ". Burger");
            orderProduct.setPrice(2D);
            orderProduct.setRemovedIngredients("peet, kapsas");
            orderProducts.add(orderProduct);
        }
        clientOrder.setOrderProducts(orderProducts);

        Location location = new Location();
        location.setId(1L);
        location.setName("branch1");
        location.setAddress("Ehitajate tee 5, 19086 Tallinn Estonia");
        location.setLon(59.3943529);
        location.setLat(24.668998869937695);
        clientOrder.setLocation(location);
        clientOrder.setEmail("a@gmail.com");
        clientOrder.setLocation(location);

        String text = "Thank you for you order!\n" +
                " \n" +
                "Order:\n" +
                " \n" +
                "0. Burger, price:2.0€\n" +
                "Removed ingredients: peet, kapsas\n" +
                " \n" +
                "1. Burger, price:2.0€\n" +
                "Removed ingredients: peet, kapsas\n" +
                " \n" +
                "2. Burger, price:2.0€\n" +
                "Removed ingredients: peet, kapsas\n" +
                " \n" +
                "3. Burger, price:2.0€\n" +
                "Removed ingredients: peet, kapsas\n" +
                " \n" +
                "Order price:10.0€\n" +
                "Pick-up location: Ehitajate tee 5, 19086 Tallinn Estonia";
        assertEquals(emailService.constructEmail(clientOrder).toString(), text);
    }

    @Test
    void emailServiceConstructMailMessage() {
        ClientOrder clientOrder = new ClientOrder();
        clientOrder.setPrice(10D);
        ArrayList<OrderProduct> orderProducts = new ArrayList<>();
        for (int i=0; i<4; i++) {
            OrderProduct orderProduct = new OrderProduct();
            orderProduct.setName(i + ". Burger");
            orderProduct.setPrice(2D);
            orderProduct.setRemovedIngredients("peet, kapsas");
            orderProducts.add(orderProduct);
        }
        clientOrder.setOrderProducts(orderProducts);

        Location location = new Location();
        location.setId(1L);
        location.setName("branch1");
        location.setAddress("Ehitajate tee 5, 19086 Tallinn Estonia");
        location.setLon(59.3943529);
        location.setLat(24.668998869937695);

        clientOrder.setLocation(location);
        clientOrder.setEmail("a@gmail.com");
        SimpleMailMessage simpleMailMessage = emailService.constructSimpleMailMessage(clientOrder);
        assertSame(Objects.requireNonNull(simpleMailMessage.getTo())[0], clientOrder.getEmail());
        assertSame(Objects.requireNonNull(simpleMailMessage.getFrom()), "taltechdonalds@gmail.com");
        assertSame(Objects.requireNonNull(simpleMailMessage.getSubject()), "TalTech Donald's Order Confirmation");
    }
}
