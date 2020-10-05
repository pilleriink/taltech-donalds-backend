package ee.taltech.backend.controller;

import ee.taltech.backend.exception.InvalidCommentException;
import ee.taltech.backend.exception.InvalidProductException;
import ee.taltech.backend.exception.ProductNotFoundException;
import ee.taltech.backend.model.comment.Comment;
import ee.taltech.backend.model.comment.CommentDto;
import ee.taltech.backend.model.comment.CommentRequest;
import ee.taltech.backend.model.product.Product;
import ee.taltech.backend.model.product.ProductDto;
import ee.taltech.backend.service.CommentService;
import ee.taltech.backend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RequestMapping("products")
@RestController
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private CommentService commentService;

    @GetMapping("/{id}")
    public ProductDto getProductById(@PathVariable Long id) throws ProductNotFoundException {
        return new ProductDto(productService.findById(id));
    }

    @PostMapping("/{productId}/comments")
    public CommentDto saveComment(@PathVariable Long productId, @RequestBody CommentRequest request) throws InvalidCommentException, ProductNotFoundException {
        Product product = productService.findById(productId);
        return new CommentDto(commentService.createNewComment(product, request));
    }

}
