package c_theory.question14.phones;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PhoneService {
    @Autowired
    private PhoneRepository phoneRepository;

    public List<Phone> getByQuery(String manufacturer, Float start, Float end, Pageable pageable) {
        return phoneRepository.getByQuery(manufacturer, start, end, pageable);
    }
    public Optional<Phone> findById(Long id) {
        return phoneRepository.findById(id);
    }
    public void deleteById(Long id) {phoneRepository.deleteById(id); }
    public Phone save(Phone phone) { return phoneRepository.save(phone); }
    public void updatePhonePrice(Float price, Long id) {
        Optional<Phone> phone = phoneRepository.findById(id);
        phone.ifPresent(p->p.setPrice(price));
    }
}
