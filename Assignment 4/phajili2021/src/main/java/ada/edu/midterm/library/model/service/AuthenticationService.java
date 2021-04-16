package ada.edu.midterm.library.model.service;

import ada.edu.midterm.library.model.entity.Users;
import org.apache.catalina.User;

public interface AuthenticationService {


    Users findUser(String email, String password);


    Users findUserByID(int id);


    Users findByToken(int token);


    void register(Users user);

    boolean checkEmail(String email);

    boolean login(String email, String password);

}
