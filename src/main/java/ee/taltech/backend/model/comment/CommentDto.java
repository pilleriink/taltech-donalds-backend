package ee.taltech.backend.model.comment;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class CommentDto {

    private Long id;
    private String comment;

    public CommentDto(Comment c) {
        this.id = c.getId();
        this.comment = c.getComment();
    }
}
