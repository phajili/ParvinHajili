package ada.edu.midterm.library.model.service.impl;

import ada.edu.midterm.library.model.dto.BookModel;
import ada.edu.midterm.library.model.entity.Books;
import ada.edu.midterm.library.model.service.BooksService;
import ada.edu.midterm.library.model.service.CommentService;
import ada.edu.midterm.library.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BooksServiceImpl implements BooksService {
    @Autowired
    private BooksRepository booksRepository;
    
    @Autowired
    private CommentService commentService;
    
    @Override
    public BookModel fetchById(Long id) throws Exception {
        Optional<Books> book = booksRepository.findById(id);
        
        if(book.isEmpty()) throw new Exception("No book found");
        
        BookModel bookModel = new BookModel(book.get());
        bookModel.setComments(commentService.getCommentByBookExtId(id));
        return bookModel;
    }
    
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
