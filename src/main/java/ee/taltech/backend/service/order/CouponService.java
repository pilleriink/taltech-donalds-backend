package ee.taltech.backend.service.order;

import ee.taltech.backend.exception.CategoryNotFoundException;
import ee.taltech.backend.exception.ProductNotFoundException;
import ee.taltech.backend.model.category.Category;
import ee.taltech.backend.model.category.CategoryDto;
import ee.taltech.backend.model.order.Coupon;
import ee.taltech.backend.model.product.Product;
import ee.taltech.backend.model.user.User;
import ee.taltech.backend.repository.CategoryRepository;
import ee.taltech.backend.repository.CouponRepository;
import ee.taltech.backend.repository.ProductRepository;
import ee.taltech.backend.service.EmailServiceImpl;
import ee.taltech.backend.service.ProductService;
import ee.taltech.backend.service.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        for (User user : userService.findAll()) {
            emailService.sendSimpleMessageCoupon(coupon, user);
        }
        return couponRepository.save(coupon);
    }

    public void delete(Long id) {
        Coupon coupon = findById(id);
        couponRepository.delete(coupon);
    }
}
