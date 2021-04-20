package ada.edu.midterm.library.controller.impl;

import ada.edu.midterm.library.controller.BookAndUserWS;
import ada.edu.midterm.library.model.entity.Users;
import ada.edu.midterm.library.model.service.AuthenticationService;
import ada.edu.midterm.library.model.service.BookAndUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lib")

public class BookAndUserWSImpl implements BookAndUserWS {
    protected static Logger logger = LoggerFactory.getLogger(AuthenticationWSImpl.class);

    @Autowired
    private BookAndUserService bookAndUserService;

    @Autowired
    private AuthenticationService authenticationService;

    @Override
    @RequestMapping(value = "/pick", method = RequestMethod.GET)
    public ResponseEntity pick(@RequestParam("bookID") int bookId, @RequestHeader("token") int token) {
        try {

            Users users = authenticationService.findByToken(token);
            bookAndUserService.pick(bookId, users.getId());
            return ResponseEntity.ok("Successfully Taken by: " + users.getFirstname());

        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @Override
    @RequestMapping(value = "/drop", method = RequestMethod.GET)
    public ResponseEntity drop(@RequestParam("bookID") int bookId, @RequestHeader("token") int token) {
        try {

            Users users = authenticationService.findByToken(token);
            bookAndUserService.drop(bookId, users.getId());
            return ResponseEntity.ok("Successfully Drop by: " + users.getFirstname());

        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @Override
    @RequestMapping(value = "/current", method = RequestMethod.GET)

    public ResponseEntity current(@RequestHeader("token") int token) {
        try {

            Users users = authenticationService.findByToken(token);

            return ResponseEntity.ok(bookAndUserService.current(users.getId()
            ));

        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @Override
    @RequestMapping(value = "/history", method = RequestMethod.GET)

    public ResponseEntity history(@RequestHeader("token") int token) {
        try {

            Users users = authenticationService.findByToken(token);

            return ResponseEntity.ok(bookAndUserService.history(users.getId()));

        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
