package ee.taltech.backend.controller;

import ee.taltech.backend.exception.*;
import ee.taltech.backend.model.category.CategoryMinifiedDto;
import ee.taltech.backend.model.comment.Comment;
import ee.taltech.backend.exception.InvalidCommentException;
import ee.taltech.backend.exception.ProductNotFoundException;
import ee.taltech.backend.model.comment.CommentDto;
import ee.taltech.backend.model.comment.CommentRequest;
import ee.taltech.backend.model.product.Product;
import ee.taltech.backend.model.product.ProductDto;
import ee.taltech.backend.security.Roles;
import ee.taltech.backend.service.CommentService;
import ee.taltech.backend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RequestMapping("products")
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private CommentService commentService;

    @GetMapping("/{id}")
    public ProductDto getProductById(@PathVariable Long id) throws ProductNotFoundException {
        return new ProductDto(productService.findById(id));
    }

    @GetMapping
    public List<ProductDto> getProducts() {
        return productService.findAll().stream().map(ProductDto::new).collect(Collectors.toList());
    }

    @Secured(Roles.ADMIN)
    @PostMapping
    public ProductDto save(@RequestBody ProductDto productDto) throws CategoryNotFoundException {
        return productService.save(productDto);
    }

    @Secured(Roles.ADMIN)
    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) throws ProductNotFoundException {
        productService.delete(id);
    }

    @PostMapping("/{productId}/comments")
    public CommentDto saveComment(@PathVariable Long productId, @RequestBody CommentRequest request) throws InvalidCommentException, ProductNotFoundException {
        Product product = productService.findById(productId);
        return new CommentDto(commentService.createNewComment(product, request));
    }

}
