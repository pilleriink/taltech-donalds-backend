package ee.taltech.backend.controller;

import ee.taltech.backend.model.advertisement.Advertisement;
import ee.taltech.backend.service.AdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("ads")
@RestController
public class AdvertisementController {

    @Autowired
    AdvertisementService service;

    @GetMapping()
    List<Advertisement> findAll() {
        return service.findAll();
    }
}
