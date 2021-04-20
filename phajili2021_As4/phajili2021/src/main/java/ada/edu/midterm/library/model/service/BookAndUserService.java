package ada.edu.midterm.library.model.service;

import ada.edu.midterm.library.model.entity.BookAndUser;
import org.springframework.stereotype.Service;

import java.util.List;


public interface BookAndUserService {


    void pick(int bookId, int userId);

    void drop(int bookId, int userId);

    List<BookAndUser> current(int userId);

    List<BookAndUser> history(int userId);


}
