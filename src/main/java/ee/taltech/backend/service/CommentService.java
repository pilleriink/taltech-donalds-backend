package ee.taltech.backend.service;

import ee.taltech.backend.exception.CommentNotFoundException;
import ee.taltech.backend.exception.InvalidCommentException;
import ee.taltech.backend.exception.InvalidProductException;
import ee.taltech.backend.model.comment.Comment;
import ee.taltech.backend.model.product.Product;
import ee.taltech.backend.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    public Comment findById(Long id) throws CommentNotFoundException {
        return commentRepository.findById(id)
                .orElseThrow(CommentNotFoundException::new);
    }

    public Comment save(Comment comment) throws InvalidCommentException {
        if(comment == null) {
            throw new InvalidCommentException("comment is invalid");
        }
        return commentRepository.save(comment);
    }
}
