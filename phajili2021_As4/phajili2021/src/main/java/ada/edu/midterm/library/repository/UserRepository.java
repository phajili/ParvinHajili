package ada.edu.midterm.library.repository;

import ada.edu.midterm.library.model.entity.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<Users, Integer> {


    Users findFirstByEmailAndPassword(String email, String password);

    Users findByToken(int token);

    Users findByEmail(String email);


}
