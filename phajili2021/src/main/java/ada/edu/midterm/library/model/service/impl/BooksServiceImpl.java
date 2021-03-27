package ada.edu.midterm.library.model.service.impl;

import ada.edu.midterm.library.model.entity.Books;
import ada.edu.midterm.library.model.service.BooksService;
import ada.edu.midterm.library.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BooksServiceImpl implements BooksService {
    @Autowired
    private BooksRepository booksRepository;


    @Override
    public List<Books> listOfBooks() {
        return booksRepository.findAll();
    }

    @Override
    public List<Books> searchByCategory(String category) {
        return booksRepository.findAllByCategory(category);
    }

    @Override
    public List<Books> searchByAuthor(String author) {
        return booksRepository.findAllByAuthor(author);
    }

    @Override
    public Books searchByName(String name) {
        return booksRepository.findByName(name);
    }
}
