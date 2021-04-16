package ada.edu.midterm.library.model.service.impl;

import ada.edu.midterm.library.model.entity.BookAndUser;
import ada.edu.midterm.library.model.service.BookAndUserService;
import ada.edu.midterm.library.repository.BookAndUserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BookAndUserServiceImpl implements BookAndUserService {

    @Autowired
    private BookAndUserRepository bookAndUserRepository;

    @Override
    public void pick(int bookId, int userId) {
        BookAndUser bookAndUser = new BookAndUser();
        bookAndUser.setBookId(bookId);
        bookAndUser.setUserId(userId);
        bookAndUser.setPickUpTime(new Date());
        bookAndUserRepository.save(bookAndUser);


    }

    @Override
    public void drop(int bookId, int userId) {
        BookAndUser bookAndUser = bookAndUserRepository.findByBookIdAndUserId(bookId, userId);
        bookAndUser.setDropOffTime(new Date());
        bookAndUserRepository.save(bookAndUser);

    }

    @Override
    public List<BookAndUser> current(int userId) {
        List<BookAndUser> bookAndUserList = bookAndUserRepository.findAllByUserId(userId);
        List<BookAndUser> result = new ArrayList<>();
        for (int i = 0; i < bookAndUserList.size(); i++) {
            if (bookAndUserList.get(i).getDropOffTime() == null && bookAndUserList.get(i).getPickUpTime() != null) {
                result.add(bookAndUserList.get(i));
            }
        }
        return result;
    }

    @Override
    public List<BookAndUser> history(int userId) {
        List<BookAndUser> bookAndUserList = bookAndUserRepository.findAllByUserId(userId);
        List<BookAndUser> result = new ArrayList<>();
        for (int i = 0; i < bookAndUserList.size(); i++) {
            if (bookAndUserList.get(i).getDropOffTime() != null && bookAndUserList.get(i).getPickUpTime() != null) {
                result.add(bookAndUserList.get(i));
            }
        }

        return result;
    }
}
