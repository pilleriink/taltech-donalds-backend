package ee.taltech.backend.repository;

import ee.taltech.backend.model.order.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CouponRepository extends JpaRepository<Coupon, Long> {

    @Override
    List<Coupon> findAll();
}
