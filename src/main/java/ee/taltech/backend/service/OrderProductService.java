package ee.taltech.backend.service;

import ee.taltech.backend.exception.InvalidOrderProductException;
import ee.taltech.backend.exception.InvalidProductException;
import ee.taltech.backend.model.order.OrderProduct;
import ee.taltech.backend.model.product.Product;
import ee.taltech.backend.repository.OrderProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderProductService {

    @Autowired
    private OrderProductRepository orderProductRepository;

    public OrderProduct save(OrderProduct orderProduct) throws InvalidOrderProductException {
        if (orderProduct.getId() == null
                || orderProduct.getRemovedProducts() == null
                || orderProduct.getClientOrder() == null) {
            throw new InvalidOrderProductException("Invalid product");
        }
        if (orderProduct.getId() != null) {
            throw new InvalidOrderProductException("Product already exists");
        }
        return orderProductRepository.save(orderProduct);
    }
}
