package ee.taltech.backend.service;

import ee.taltech.backend.model.advertisement.Advertisement;
import ee.taltech.backend.repository.AdvertisementRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AdvertisementService {

    @Autowired
    private AdvertisementRepository advertisementRepository;

    public List<Advertisement> findAll() {
        return advertisementRepository.findAll();
    }
}
