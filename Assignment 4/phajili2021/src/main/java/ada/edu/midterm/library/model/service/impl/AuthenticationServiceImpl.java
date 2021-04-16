package ada.edu.midterm.library.model.service.impl;

import ada.edu.midterm.library.repository.UserRepository;
import ada.edu.midterm.library.model.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ada.edu.midterm.library.model.service.AuthenticationService;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public Users findUser(String email, String password) {
        return userRepository.findFirstByEmailAndPassword(email, password);
    }


    @Override
    public Users findUserByID(int id) {
        return userRepository.findById(id).get();
    }

    @Override
    public Users findByToken(int token) {
        return userRepository.findByToken(token);
    }

    @Override
    public void register(Users user) {
        userRepository.save(user);

    }

    @Override
    public boolean checkEmail(String email) {
        if (userRepository.findByEmail(email) != null) {
            return true;
        }
        return false;
    }

    @Override
    public boolean login(String email, String password) {
        if (userRepository.findFirstByEmailAndPassword(email, password) != null) {
            return true;
        }
        return false;
    }
}
