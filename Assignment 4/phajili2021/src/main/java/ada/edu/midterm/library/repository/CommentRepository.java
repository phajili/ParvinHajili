package ada.edu.midterm.library.repository;

import ada.edu.midterm.library.model.entity.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommentRepository extends MongoRepository<Comment, String> {
    Optional<List<Comment>> findAllByBookExtId(String id);
}
