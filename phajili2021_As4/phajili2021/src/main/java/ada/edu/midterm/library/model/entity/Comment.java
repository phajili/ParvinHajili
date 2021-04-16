package ada.edu.midterm.library.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Data
@Document
public class Comment {
    @Id
    private String id;
    private String bookExtId;
    private String commentAuthorName;
    private String commentContent;
    private List<Comment> replies = new ArrayList<>();
    
    public Comment(String bookExtId, String commentAuthorName, String commentContent)
    {
        this.bookExtId = bookExtId;
        this.commentAuthorName = commentAuthorName;
        this.commentContent = commentContent;
    }
}
