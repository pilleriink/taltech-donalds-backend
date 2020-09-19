package ee.taltech.backend;

import ee.taltech.backend.model.Product;
import ee.taltech.backend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductsInit implements CommandLineRunner {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {
        productRepository.deleteAll();
        List<Product> productList = List.of(
                createProduct("Chicken burger",
                        "Delicious chicken burger",
                        "", "chicken, sauce, cheese",
                        2.99),
                createProduct("Veggie burger",
                        "Delicious veggie burger",
                        "", "tofu, sauce, cheese",
                        2.99),
                createProduct("Fries",
                        "Delicious fries",
                        "", "salt",
                        1.99),
                createProduct("Chicken nuggets",
                        "Delicious chicken nuggets",
                        "", "salt",
                        1.99),
                createProduct("Coca-Cola",
                        "Delicious Coca-Cola",
                        "", "ice",
                        0.99)
        );


        productRepository.saveAll(productList);
    }

    public Product createProduct(String name, String description, String image, String removableIngredients, Double price) {
        Product product = new Product();
        product.setName(name);
        product.setDescription(description);
        product.setImage(image);
        product.setRemovableIngredients(removableIngredients);
        product.setPrice(price);
        //also category?
        return product;
    }
}
