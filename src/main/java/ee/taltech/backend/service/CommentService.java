package ee.taltech.backend.service;

import ee.taltech.backend.exception.CommentNotFoundException;
import ee.taltech.backend.model.comment.Comment;
import ee.taltech.backend.model.product.Product;
import ee.taltech.backend.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    public Comment findById(Long id) throws CommentNotFoundException {
        return commentRepository.findById(id)
                .orElseThrow(CommentNotFoundException::new);
    }

}
