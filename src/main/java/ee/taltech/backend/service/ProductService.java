package ee.taltech.backend.service;

import ee.taltech.backend.exception.InvalidCommentException;
import ee.taltech.backend.exception.InvalidProductException;
import ee.taltech.backend.exception.ProductNotFoundException;
import ee.taltech.backend.model.comment.Comment;
import ee.taltech.backend.model.product.Product;
import ee.taltech.backend.repository.ProductRepository;
import ee.taltech.backend.repository.CommentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product findById(Long id) throws ProductNotFoundException {
        return productRepository.findById(id)
                .orElseThrow(ProductNotFoundException::new);
    }

}
