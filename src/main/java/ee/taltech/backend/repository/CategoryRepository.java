package ee.taltech.backend.repository;

import ee.taltech.backend.model.Category;
import ee.taltech.backend.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository  extends JpaRepository<Category, Long> {

    Category findByName(String name);
}
