package ee.taltech.backend.repository;

import ee.taltech.backend.model.category.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository  extends JpaRepository<Category, Long> {

    Category findByName(String name);
}
