package ee.taltech.backend.controller;

import ee.taltech.backend.exception.ProductNotFoundException;
import ee.taltech.backend.model.advertisement.Advertisement;
import ee.taltech.backend.model.category.CategoryDto;
import ee.taltech.backend.service.AdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public class AdvertisementController {

    @Autowired
    AdvertisementService service;

    @GetMapping("/ads")
    List<Advertisement> findAll() {
        return service.findAll();
    }
}
