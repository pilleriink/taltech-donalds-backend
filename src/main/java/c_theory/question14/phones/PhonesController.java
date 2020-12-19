package c_theory.question14.phones;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/phones")
public class PhonesController {

    //todo for question 14 there are 4 assignments in total
    // Each person has to do only 1. So 2 person team has to do 2 different ones, 3 person - 3, 4 person - 4.
    // Make sure to commit under your user otherwise points won't count.
    // I didn't number these so you can pick your favorite

    //todo
    // You are creating a rest controller for lessons. Think of a phone shop.
    // You need to add necessary annotations and methods to this class.
    // This class should compile.
    // It should run successfully when moved to your application package.
    // Method body is not important and will not be graded.
    // Modifying other classes is unnecessary and will not be graded.

    //todo A add necessary annotations on the class

    //todo B create a method to query phones (plural)

    //todo C create a method to query single phone

    //todo D create a method to save a phone

    //todo E create a method to update a phone

    //todo F create a method to delete a phone

    //todo G assuming each phone has apps installed (one-to-many relation) create a method to query phone's apps

    //todo H create a method to update phone's price (and nothing else)

    //todo I modify correct method to support searching by manufacturer while keeping original functionality

    //todo J modify correct method to support searching by price range: priceFrom-priceTo while keeping original functionality

    //todo K modify correct method to order/sort phones
    // * by latest released date first
    // * by earliest released date first
    // (you can assume that by default it searches most popular first)

    @Autowired
    private PhoneService phoneService;
    @Autowired
    private AppService appService;

    @GetMapping(value = "/")
    public List<Phone> getPhones (@RequestParam(value="manufacturer", required = false) String manufacturer,
                                  @RequestParam(value="from", required = false) Float start,
                                  @RequestParam(value="to", required = false) Float end,
                                  @RequestParam(value="direction", required = false) Sort.Direction direction,
                                  Pageable pageable) {
        return null;
        //return phoneService.getByQuery(manufacturer, start, end, pageable, direction);
    }

    @GetMapping(value="/{id}")
    public Optional<Phone> getPhoneById(@PathVariable("id") Long id) {
        return null;
        //return phoneService.findById(id);
    }

    @PostMapping("/")
    @ResponseBody
    public Phone savePhone(@RequestBody Phone phone){
        return null;
        //return phoneService.save(phone);
    }

    @PutMapping("/{id}")
    public Phone updatePhone(@RequestBody Phone phone) {
        return null;
        //return phoneService.save(phone);
    }

    @DeleteMapping("/{id}")
    public void deletePhoneById(@PathVariable("id") Long id) {
        //phoneService.deleteById(id);
    }

    @GetMapping("/{id}/apps")
    public List<App> getAppsByPhoneId(@PathVariable("id") Long id) {
        return null;
        //return appService.findByPhoneId(id);
    }

    @PatchMapping("/{id}")
    public void updatePhonePrice(@RequestParam Float price, @PathVariable("id") Long id) {
        //phoneService.updatePhonePrice(price, id);
    }
}
