package ee.taltech.backend.controller;

import ee.taltech.backend.model.location.Location;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("locations")
@RestController
public class LocationController {
    private List<Location> locations = new ArrayList<>();

    public LocationController() {
    }

    @GetMapping
    public List<Location> getLocations() {
        return locations;
    }
}
