package ee.taltech.backend.service;

import ee.taltech.backend.exception.InvalidCommentException;
import ee.taltech.backend.model.comment.Comment;
import ee.taltech.backend.model.comment.CommentRequest;
import ee.taltech.backend.model.product.Product;
import ee.taltech.backend.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    public Comment createNewComment(Product product, CommentRequest request) throws InvalidCommentException {
        if (product == null || request == null) {
            throw new InvalidCommentException("Invalid comment request");
        }
        Comment comment = new Comment();
        comment.setProduct(product);
        comment.setComment(request.getComment());
        return save(comment);
    }

    public Comment save(Comment comment) throws InvalidCommentException {
        if(comment == null || comment.getComment() == null || comment.getProduct() == null) {
            throw new InvalidCommentException("comment is invalid");
        }
        return commentRepository.save(comment);
    }
}
