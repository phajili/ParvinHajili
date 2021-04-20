package ada.edu.midterm.library.controller;

import org.springframework.http.ResponseEntity;

public interface BookAndUserWS {

    ResponseEntity pick(int bookId, int token);

    ResponseEntity drop(int bookId, int token);

    ResponseEntity current(int token);

    ResponseEntity history(int token);

}
