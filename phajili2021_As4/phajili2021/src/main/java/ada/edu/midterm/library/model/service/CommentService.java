package ada.edu.midterm.library.model.service;

import ada.edu.midterm.library.model.dto.CommentModel;
import ada.edu.midterm.library.model.entity.Comment;

import java.util.List;

public interface CommentService {

    List<CommentModel> getCommentByBookExtId(long id );
    boolean postComment(String author, long bookid, String commentText);
    boolean postReply(String author, String commentid, String replyText);
}
