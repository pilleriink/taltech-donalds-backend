package ee.taltech.backend.controller;

import ee.taltech.backend.model.location.Location;
import ee.taltech.backend.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("locations")
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class LocationController {
    @Autowired
    private LocationService locationService;

    @GetMapping
    public List<Location> getLocations() {
        return locationService.findAll();
    }
}
