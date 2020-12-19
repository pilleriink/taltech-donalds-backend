package c_theory.question14.phones;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppService {
    @Autowired
    private AppRepository appRepository;

    List<App> findByPhoneId(Long id) {
        return appRepository.findAllByPhoneId(id);
    }
}
