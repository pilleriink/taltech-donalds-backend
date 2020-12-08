package ee.taltech.backend.controller;

import ee.taltech.backend.exception.CategoryNotFoundException;
import ee.taltech.backend.exception.ProductNotFoundException;
import ee.taltech.backend.model.category.CategoryDto;
import ee.taltech.backend.model.category.CategoryMinifiedDto;
import ee.taltech.backend.model.order.Coupon;
import ee.taltech.backend.security.Roles;
import ee.taltech.backend.service.CategoryService;
import ee.taltech.backend.service.order.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("coupons")
@RestController
public class CouponController {
    @Autowired
    CouponService couponService;

    @GetMapping
    public List<Coupon> findAll() {
        return couponService.findAll();
    }

    @GetMapping("/{id}")
    public Coupon getCouponById(@PathVariable Long id) {
        return couponService.findById(id);
    }

    @Secured(Roles.ADMIN)
    @PostMapping
    public Coupon save(@RequestBody Coupon coupon){
        return couponService.save(coupon);
    }

    @Secured(Roles.ADMIN)
    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        couponService.delete(id);
    }
}
