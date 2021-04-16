package ada.edu.midterm.library.controller.impl;

import ada.edu.midterm.library.controller.AuthenticationWS;
import ada.edu.midterm.library.model.entity.Users;
import org.springframework.http.ResponseEntity;

public class AuthenticationWSLDAPImpl implements AuthenticationWS {

    @Override
    public ResponseEntity login(String email, String password) {
        return null;
    }

    @Override
    public ResponseEntity register(Users users) {
        return null;
    }


}
