package ee.taltech.backend.controller;

import ee.taltech.backend.model.advertisement.Advertisement;
import ee.taltech.backend.security.Roles;
import ee.taltech.backend.service.AdvertisementService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("ads")
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AdvertisementController {

    @Autowired
    AdvertisementService service;

    @GetMapping()
    public List<Advertisement> findAll() {
        return service.findAll();
    }

}
