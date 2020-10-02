package ee.taltech.backend.controller;

import ee.taltech.backend.exception.InvalidCommentException;
import ee.taltech.backend.exception.InvalidProductException;
import ee.taltech.backend.exception.ProductNotFoundException;
import ee.taltech.backend.model.comment.Comment;
import ee.taltech.backend.model.comment.CommentDto;
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

    @PostMapping
    public Product saveProduct(@RequestBody Product product) throws InvalidProductException {
        return productService.save(product);
    }

    @PostMapping("/{id}/comments")
    public Comment saveComment(@RequestBody Comment comment) throws InvalidCommentException {
        return commentService.save(comment);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@RequestBody Product product, @PathVariable Long id) throws InvalidProductException, ProductNotFoundException {
        return productService.update(product, id);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) throws ProductNotFoundException {
        productService.delete(id);
    }


    //todo validation?
    //todo add tests

}
