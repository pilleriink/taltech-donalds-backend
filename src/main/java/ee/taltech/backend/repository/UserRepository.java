package ee.taltech.backend.repository;

import ee.taltech.backend.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByUsername(String username);

    List<User> findAllByUsername(String username);

}

