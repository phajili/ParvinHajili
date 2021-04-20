package ada.edu.midterm.library.controller.impl;

import ada.edu.midterm.library.controller.BooksWS;
import ada.edu.midterm.library.model.dto.BookModel;
import ada.edu.midterm.library.model.entity.Books;
import ada.edu.midterm.library.model.entity.Comment;
import ada.edu.midterm.library.model.entity.Users;
import ada.edu.midterm.library.model.service.AuthenticationService;
import ada.edu.midterm.library.model.service.BooksService;
import ada.edu.midterm.library.model.service.CommentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lib")
public class BooksWSImpl implements BooksWS {

    protected static Logger logger = LoggerFactory.getLogger(AuthenticationWSImpl.class);

    @Autowired
    private BooksService booksService;
    
    @Autowired
    private AuthenticationService authenticationService;
    
    @Autowired
    private CommentService commentService;
    
    @Override
    @PostMapping("/writeComment/{book_id}")
    public ResponseEntity writeComment(
            @RequestHeader("token") int token,
            @PathVariable int book_id,
            @RequestParam("comment") String comment)
    {
        try {
            Users user = authenticationService.findByToken(token);
            commentService.postComment(user.getFirstname(), book_id, comment);
            return ResponseEntity.ok("COMMENT POSTED");
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
    @Override
    @PostMapping("/replyComment/{comment_id}")
    public ResponseEntity writeReply(
            @RequestHeader int token,
            @PathVariable String comment_id,
            @RequestParam String comment)
    {
        try {
            Users user = authenticationService.findByToken(token);
            commentService.postReply(user.getFirstname(), comment_id, comment);
            
            return ResponseEntity.ok("REPLY POSTED");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
    @Override
    @GetMapping("/{id}")
    public ResponseEntity getBooksById(@PathVariable("id") int book_id) {
        try {
            BookModel book = booksService.fetchById((long) book_id);
            return ResponseEntity.ok(book);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    @RequestMapping(value = "/bookByName", method = RequestMethod.GET)
    public ResponseEntity searchByName(@RequestParam("book") String name) {
        logger.info("Search By Book Name: " + name);
        return ResponseEntity.ok(booksService.searchByName(name));
    }

    @Override
    @RequestMapping(value = "/bookByCategory", method = RequestMethod.GET)

    public ResponseEntity searchByCategory(@RequestParam("category") String category) {
        logger.info("Search By Category: " + category);

        return ResponseEntity.ok(booksService.searchByCategory(category));
    }

    @Override
    @RequestMapping(value = "/bookByAuthor", method = RequestMethod.GET)

    public ResponseEntity searchByAuthor(@RequestParam("author") String author) {
        logger.info("Search By Author: " + author);

        return ResponseEntity.ok(booksService.searchByAuthor(author));
    }

    @Override
    @RequestMapping(value = "/books", method = RequestMethod.GET)

    public ResponseEntity allBooks() {
        return ResponseEntity.ok(booksService.listOfBooks());

    }
}
