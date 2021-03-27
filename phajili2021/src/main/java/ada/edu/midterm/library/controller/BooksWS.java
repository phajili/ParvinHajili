package ada.edu.midterm.library.controller;

import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;


public interface BooksWS {
    ResponseEntity searchByName(String name);

    ResponseEntity searchByCategory(String category);

    ResponseEntity searchByAuthor(String author);

    ResponseEntity allBooks();


}
