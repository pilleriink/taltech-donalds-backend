package c_theory.question14.phones;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PhoneRepository extends JpaRepository<Phone, Long> {
            @Query("select p from Phone p where " +
                    "(?1 is null or upper(p.name) like concat('%', upper(?1), '%')) " +
                    "and (?2 is null or p.createdAt >= ?2) " +
                    "and (?3 is null or p.createdAt <= ?3)")
            List<Phone> getByQuery(String manufacturer, Float start, Float end, Pageable pageable);
}