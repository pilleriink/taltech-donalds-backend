package ee.taltech.backend.controller;

import ee.taltech.backend.model.location.Location;
import ee.taltech.backend.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("locations")
@RestController
public class LocationController {
    @Autowired
    private LocationService locationService;

    @GetMapping
    public List<Location> getLocations(@RequestParam(value="name", required=false) String name) {
        return locationService.findAll(name);
    }
}
