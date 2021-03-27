package ada.edu.midterm.library.model.service;

import ada.edu.midterm.library.model.entity.Books;

import java.util.List;

public interface BooksService {


    List<Books> listOfBooks();


    List<Books> searchByCategory(String category);

    List<Books> searchByAuthor(String author);

    Books searchByName(String name);

}
