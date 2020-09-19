package ee.taltech.backend;

import ee.taltech.backend.model.Category;
import ee.taltech.backend.model.Product;
import ee.taltech.backend.repository.CategoryRepository;
import ee.taltech.backend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ApplicationInit implements CommandLineRunner {

    //this will be admin's job once we have different roles

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;

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
                        "", "chicken, sauce, cheese",
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
