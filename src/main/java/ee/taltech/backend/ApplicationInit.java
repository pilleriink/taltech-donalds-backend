package ee.taltech.backend;

import ee.taltech.backend.model.advertisement.Advertisement;
import ee.taltech.backend.model.category.Category;
import ee.taltech.backend.model.comment.Comment;
import ee.taltech.backend.model.location.Location;
import ee.taltech.backend.model.meal.Meal;
import ee.taltech.backend.model.product.Product;
import ee.taltech.backend.repository.*;
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
    @Autowired
    MealRepository mealRepository;
    @Autowired
    private AdvertisementRepository advertisementRepository;

    @Override
    public void run(String... args) throws Exception {
        List<Category> categoryList = List.of(
                createCategory("Burgers"),
                createCategory("Finger food"),
                createCategory("Drinks")
        );
        categoryRepository.saveAll(categoryList);

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
                createLocation("branch1", "Ehitajate tee 5, 19086 Tallinn Estonia", 59.3943529, 24.668998869937695),
                createLocation("branch2", "Raja 4, 12616 Tallinn Estonia", 59.391073, 24.6640777)
        );
        locationRepository.saveAll(locationList);

        commentRepository.save(new Comment(1L, "this burger is great!", productRepository.findByName("Chicken burger")));

        List<Meal> mealList = List.of(
                createMeal("Chicken Burger Meal", "Chicken Burger Meal With Fries And Coca-Cola",
                        "https://charlixplace.com/wp-content/uploads/2020/06/burger.jpg",
                        List.of(productList.get(0), productList.get(5), productList.get(7))),
                createMeal("Veggie Burger meal", "Veggie Burger Meal With Fries And Coca-Cola", "",
                        List.of(productList.get(2), productList.get(5), productList.get(7)))

        );
        mealRepository.saveAll(mealList);

        for (Meal meal : mealList) {
            for (Product product : meal.getProducts()) {
                product.addMeal(meal);
            }
        }

        List<Advertisement> advertisementList = List.of(  // Big ads MUST have 'big' and small ads MUST have 'small' in alt.
                new Advertisement("https://i.ibb.co/ctHpWhD/ttd1.jpg", "products/4", "TTD bigAd1"),
                new Advertisement("https://i.ibb.co/WsXDnXh/ttd2.jpg", "products/5", "TTD bigAd2"),
                new Advertisement("https://i.ibb.co/6RPWjqQ/ttd4.jpg", "products/6", "TTD bigAd3"),
                new Advertisement("https://i.ibb.co/DK4JZTY/smallAd1.jpg", "locations", "TTD smallAd1"),
                new Advertisement("https://i.ibb.co/xz4wkGQ/smallAd2.jpg", "categories/1", "TTD smallAd2"),
                new Advertisement("https://i.ibb.co/tLXzZrz/ttd5.png", "cart", "TTD bigAd4")
        );
        advertisementRepository.saveAll(advertisementList);
    }

    public Location createLocation(String name, String address, Double lon, Double lat) {
        Location location = new Location();
        location.setName(name);
        location.setAddress(address);
        location.setLon(lon);
        location.setLat(lat);
        return location;
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

    public Meal createMeal(String name, String description, String image, List<Product> products) {
        Meal meal = new Meal();
        meal.setName(name);
        meal.setDescription(description);
        meal.setImage(image);
        meal.setProducts(products);
        double count = 0;
        for (Product product : products) {
            count += product.getPrice();
        }
        meal.setPrice(count * 0.9);
        return meal;
    }

}
