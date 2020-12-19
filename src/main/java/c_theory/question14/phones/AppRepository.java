package c_theory.question14.phones;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppRepository extends JpaRepository<App, Long> {
    @Query("select a from Apps a where a.phoneId = ?1 order by ?2")
    List<App> findAllByPhoneId(Long id, Sort.Direction direction);
}
