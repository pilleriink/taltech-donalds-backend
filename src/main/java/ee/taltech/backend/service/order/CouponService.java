package ee.taltech.backend.service.order;

import ee.taltech.backend.model.order.Coupon;
import ee.taltech.backend.model.user.User;
import ee.taltech.backend.repository.CouponRepository;
import ee.taltech.backend.service.EmailServiceImpl;
import ee.taltech.backend.service.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CouponService {
    @Autowired
    CouponRepository couponRepository;
    @Autowired
    EmailServiceImpl emailService;
    @Autowired
    UserService userService;

    public List<Coupon> findAll() {
        return couponRepository.findAll();
    }

    public Coupon findById(Long id) {
        return couponRepository.findById(id).orElseThrow();
    }

    public Coupon save(Coupon coupon) {
        Coupon coupon1 = couponRepository.save(coupon);
        for (User user : userService.findAll()) {
            emailService.sendSimpleMessageCoupon(coupon, user);
        }
        return coupon1;
    }

    public void delete(Long id) {
        Coupon coupon = findById(id);
        couponRepository.delete(coupon);
    }
}
