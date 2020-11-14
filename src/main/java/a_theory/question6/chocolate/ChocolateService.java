package a_theory.question6.chocolate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class ChocolateService {

    @Autowired
    ChocolateRepository chocolateRepository;

    public List<Cake> getCakes(@RequestParam(value = "ingredients", required = false) List<String> ingredients,
                               @RequestParam(value = "toppings", required = false) List<String> toppings) {
        return List.of();
    }

    public Cake addCake(@RequestBody Cake cake) {
        return cake;
    }

    public Cake updateCake(@RequestBody Cake cake, @PathVariable Long id) {
        return cake;
    }

}
