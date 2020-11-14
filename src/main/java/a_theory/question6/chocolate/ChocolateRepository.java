package a_theory.question6.chocolate;

import ee.taltech.backend.model.advertisement.Advertisement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChocolateRepository extends JpaRepository<Advertisement, Long> {
}
