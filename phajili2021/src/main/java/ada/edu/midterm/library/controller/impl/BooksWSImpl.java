package ada.edu.midterm.library.controller.impl;

import ada.edu.midterm.library.controller.BooksWS;
import ada.edu.midterm.library.model.service.BooksService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lib")
public class BooksWSImpl implements BooksWS {

    protected static Logger logger = LoggerFactory.getLogger(AuthenticationWSImpl.class);

    @Autowired
    private BooksService booksService;

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
