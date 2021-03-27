package ada.edu.midterm.library.controller.impl;

import ada.edu.midterm.library.controller.AuthenticationWS;
import ada.edu.midterm.library.model.entity.Users;
import ada.edu.midterm.library.model.service.AuthenticationService;
import ada.edu.midterm.library.utils.SHAAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
@RequestMapping("/auth")
public class AuthenticationWSImpl implements AuthenticationWS {

    protected static Logger logger = LoggerFactory.getLogger(AuthenticationWSImpl.class);


    @Autowired
    private AuthenticationService authenticationService;

    @Override
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ResponseEntity login(
            @RequestHeader("email") String email,
            @RequestHeader("password") String password
    ) {


        try {
            if (authenticationService.login(email, (SHAAlgorithm.toHexString(SHAAlgorithm.getSHA(password))))) {
                return ResponseEntity.ok().body("Login Successfully!");

            }
            logger.info("Email registred before");
            return ResponseEntity.badRequest().body("This Email existed in DB");


        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }


    @Override
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity register(@RequestBody Users users) {

        try {

            if (authenticationService.checkEmail(users.getEmail())==false) {
                Random random = new Random();
                int token = random.nextInt(1000);
                users.setToken(token);
                users.setPassword(SHAAlgorithm.toHexString(SHAAlgorithm.getSHA(users.getPassword())));
                authenticationService.register(users);
                return ResponseEntity.ok("DONE");
            }
            logger.info("Email registred before");
            return ResponseEntity.badRequest().body("This Email existed in DB");


        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }


}
