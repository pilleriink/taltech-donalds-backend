package ee.taltech.backend.controller;

import ee.taltech.backend.model.location.Location;
import ee.taltech.backend.security.Roles;
import ee.taltech.backend.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

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

    @Secured(Roles.ADMIN)
    @PostMapping
    public Location save(@RequestBody Location location){
        return locationService.save(location);
    }

    @Secured(Roles.ADMIN)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        locationService.delete(id);
    }
}
