package ada.edu.midterm.library.repository;

import ada.edu.midterm.library.model.entity.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BooksRepository extends JpaRepository<Books, Integer> {
    Books findByName(String name);

    List<Books> findAllByCategory(String category);

    List<Books> findAllByAuthor(String author);


}