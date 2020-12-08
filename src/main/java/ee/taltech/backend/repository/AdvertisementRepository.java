package ee.taltech.backend.repository;

import ee.taltech.backend.model.advertisement.Advertisement;
import ee.taltech.backend.model.comment.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdvertisementRepository extends JpaRepository<Advertisement, Long> {

    @Override
    Optional<Advertisement> findById(Long aLong);
}
