package ada.edu.midterm.library.model.dto;

import ada.edu.midterm.library.model.entity.Comment;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@NoArgsConstructor
@Data

public class CommentModel {

    private String id;
    private String author_name;
    private String content;

    private List<CommentModel> replies;
    
    public CommentModel(Comment comment)
    {
        this.id = comment.getId();
        this.author_name = comment.getCommentAuthorName();
        this.content = comment.getCommentContent();
        
        if(comment.getReplies().isEmpty()) return;
        
        this.replies = new ArrayList<>();
        comment.getReplies().stream().forEach(commentEntity -> {
            this.replies.add(new CommentModel(commentEntity));
        });
    }
}
