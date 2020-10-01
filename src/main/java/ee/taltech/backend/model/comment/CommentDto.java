package ee.taltech.backend.model.comment;

import lombok.*;

@Getter
@Setter
public class CommentDto {

    private Long id;
    //private String username;
    private String comment;

    public CommentDto(Comment c) {
        this.id = c.getId();
        this.comment = c.getComment();
    }
}
