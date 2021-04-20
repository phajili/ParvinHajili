package ada.edu.midterm.library.repository;

import ada.edu.midterm.library.model.entity.BookAndUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookAndUserRepository extends CrudRepository<BookAndUser, Integer> {

    BookAndUser findByBookIdAndUserId(int bookId, int userId);

    List<BookAndUser> findAllByUserId(int userId);



}
