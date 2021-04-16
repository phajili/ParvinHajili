package ada.edu.midterm.library.controller.impl;

import ada.edu.midterm.library.controller.BooksWS;
import org.springframework.http.ResponseEntity;

public class BooksWSLDAImpl implements BooksWS {


    @Override
    public ResponseEntity searchByName(String name) {
        return null;
    }

    @Override
    public ResponseEntity searchByCategory(String category) {
        return null;
    }

    @Override
    public ResponseEntity searchByAuthor(String author) {
        return null;
    }

    @Override
    public ResponseEntity allBooks() {
        return null;
    }

    @Override
    public ResponseEntity getBooksById(int book_id) {
        return null;
    }
    
    @Override
    public ResponseEntity writeComment(int token, int book_id, String comment)
    {
        return null;
    }
    
    @Override
    public ResponseEntity writeReply(int token, String comment_id, String comment)
    {
        return null;
    }
}
