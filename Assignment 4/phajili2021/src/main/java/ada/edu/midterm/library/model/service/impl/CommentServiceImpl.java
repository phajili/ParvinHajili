package ada.edu.midterm.library.model.service.impl;

import ada.edu.midterm.library.model.dto.CommentModel;
import ada.edu.midterm.library.model.entity.Comment;
import ada.edu.midterm.library.model.service.CommentService;
import ada.edu.midterm.library.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {
    
    private CommentRepository commentRepository;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public List<CommentModel> getCommentByBookExtId(long id) {
        List<CommentModel> comments = new ArrayList<>(1);
        
        Optional<List<Comment>> result = commentRepository.findAllByBookExtId(String.valueOf(id));
        if (result.isEmpty()) return comments;
        if (result.get().size() > 0) {
            result.get().stream().forEach(commentEntity -> {
                comments.add(new CommentModel(commentEntity));
            });
        }
        return comments;
    }
    
    @Override
    public boolean postComment(String author, long bookid, String commentText)
    {
        Comment comment = new Comment(String.valueOf(bookid), author, commentText);
        
        commentRepository.save(comment);
        
        return true;
    }
    
    @Override
    public boolean postReply(String author, String commentid, String replyText)
    {
        Optional<Comment> originalComment = commentRepository.findById(commentid);
        if(originalComment.isPresent())
        {
            Comment reply = new Comment(originalComment.get().getBookExtId(), originalComment.get().getCommentAuthorName(), replyText);
            originalComment.get().getReplies().add(reply);
            commentRepository.save(originalComment.get());
            return true;
        }
        else
        {
            return false;
        }
    }
}
