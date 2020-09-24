package ee.taltech.backend.controller;

import ee.taltech.backend.model.location.Location;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("location")
@RestController
public class LocationController {
    private List<Location> locations = new ArrayList<>();

    public LocationController() {
        this.locations.add(new Location("branch1", "Ehitajate tee 5, 19086 Tallinn Estonia",59.3943529, 24.668998869937695));
        this.locations.add(new Location("branch2", "Raja 4, 12616 Tallinn", 24.6640777, 59.391073));
    }

    @GetMapping
    public List<Location> getLocations() {
        return locations;
    }
}
