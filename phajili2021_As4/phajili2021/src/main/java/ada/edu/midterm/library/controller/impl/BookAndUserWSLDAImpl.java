package ada.edu.midterm.library.controller.impl;

import ada.edu.midterm.library.controller.BookAndUserWS;
import org.springframework.http.ResponseEntity;

public class BookAndUserWSLDAImpl implements BookAndUserWS {
    @Override
    public ResponseEntity pick(int bookId, int token) {
        return null;
    }

    @Override
    public ResponseEntity drop(int bookId, int token) {
        return null;
    }

    @Override
    public ResponseEntity current(int token) {
        return null;
    }

    @Override
    public ResponseEntity history(int token) {
        return null;
    }
}
