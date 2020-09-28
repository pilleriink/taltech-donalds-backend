package ee.taltech.backend.service;

import ee.taltech.backend.model.location.Location;
import ee.taltech.backend.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {

    @Autowired
    private LocationRepository locationRepository;

    public List<Location> findAll(String name) {
        return locationRepository.findAll();
    }
}
