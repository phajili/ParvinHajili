package ada.edu.midterm.library.controller;

import ada.edu.midterm.library.model.entity.Users;
import org.springframework.http.ResponseEntity;

public interface AuthenticationWS {
    ResponseEntity login(String email, String password);

    ResponseEntity register(Users users);


}
