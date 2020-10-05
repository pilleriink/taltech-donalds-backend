package ee.taltech.backend;

import ee.taltech.backend.model.category.Category;
import ee.taltech.backend.model.comment.Comment;
import ee.taltech.backend.model.location.Location;
import ee.taltech.backend.model.product.Product;
import ee.taltech.backend.repository.CategoryRepository;
import ee.taltech.backend.repository.CommentRepository;
import ee.taltech.backend.repository.ProductRepository;
import ee.taltech.backend.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ApplicationInit implements CommandLineRunner {

    //this will be admin's job once we have different roles

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private LocationRepository locationRepository;
    @Autowired
    private CommentRepository commentRepository;
    @Override
    public void run(String... args) throws Exception {
        categoryRepository.deleteAll();
        List<Category> categoryList = List.of(
                createCategory("Burgers"),
                createCategory("Finger food"),
                createCategory("Drinks")
        );
        categoryRepository.saveAll(categoryList);

        productRepository.deleteAll();
        List<Product> productList = List.of(
                createProduct("Chicken burger",
                        "Delicious chicken burger",
                        "https://charlixplace.com/wp-content/uploads/2020/06/burger.jpg", "chicken, sauce, cheese",
                        2.99, "Burgers"),
                createProduct("Bacon burger",
                        "Delicious bacon burger",
                        "", "tofu, sauce, cheese",
                        2.99, "Burgers"),
                createProduct("Tofu burger",
                        "Delicious tofu burger",
                        "https://charlixplace.com/wp-content/uploads/2020/06/burger.jpg", "tofu, sauce, cheese",
                        2.99, "Burgers"),
                createProduct("Naked burger",
                        "Delicious naked burger",
                        "https://charlixplace.com/wp-content/uploads/2020/06/burger.jpg", "tofu, sauce, cheese",
                        2.99, "Burgers"),
                createProduct("Veggie burger",
                        "Delicious veggie burger",
                        "", "tofu, sauce, cheese",
                        2.99, "Burgers"),
                createProduct("Fries",
                        "Delicious fries",
                        "", "salt",
                        1.99, "Finger food"),
                createProduct("Chicken nuggets",
                        "Delicious chicken nuggets",
                        "", "salt",
                        1.99, "Finger food"),
                createProduct("Coca-Cola",
                        "Delicious Coca-Cola",
                        "", "ice",
                        0.99, "Drinks")
        );

        productRepository.saveAll(productList);

        List<Location> locationList = List.of(
                new Location(1L,"branch1", "Ehitajate tee 5, 19086 Tallinn Estonia",59.3943529, 24.668998869937695),
                new Location(2L, "branch2", "Raja 4, 12616 Tallinn Estonia",59.391073 , 24.6640777)
        );
        locationRepository.saveAll(locationList);

        Product chicken_burger = productRepository.findByName("Chicken burger");
        List<Comment> commentList = List.of(
                new Comment(1L, "this burger is great!", chicken_burger)
        );
        commentRepository.saveAll(commentList);

    }

    public Product createProduct(String name, String description, String image, String removableIngredients, Double price, String category) {
        Product product = new Product();
        product.setName(name);
        product.setDescription(description);
        product.setImage(image);
        product.setRemovableIngredients(removableIngredients);
        product.setPrice(price);
        product.setCategory(categoryRepository.findByName(category));
        return product;
    }

    public Category createCategory(String name) {
        Category category = new Category();
        category.setName(name);
        return category;
    }
}
