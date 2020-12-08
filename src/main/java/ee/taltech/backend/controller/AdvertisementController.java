package ee.taltech.backend.controller;

import ee.taltech.backend.exception.CategoryNotFoundException;
import ee.taltech.backend.exception.ProductNotFoundException;
import ee.taltech.backend.model.advertisement.Advertisement;
import ee.taltech.backend.model.category.CategoryDto;
import ee.taltech.backend.security.Roles;
import ee.taltech.backend.service.AdvertisementService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping({"ads", "ads2"})
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AdvertisementController {

    @Autowired
    AdvertisementService service;

    @GetMapping()
    public List<Advertisement> findAll() {
        return service.findAll();
    }

    @Secured(Roles.ADMIN)
    @PostMapping
    public Advertisement save(@RequestBody Advertisement advertisement){
        return service.save(advertisement);
    }

    @Secured(Roles.ADMIN)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

}
