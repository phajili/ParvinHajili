package ada.edu.midterm.library.model.entity;


import ada.edu.midterm.library.model.dto.CommentModel;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "books")
public class Books {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String category;
    private String author;
    private String publishedDate;
    private int takenBy;
    
//    private List<CommentModel> comments;


    public Books(String name, String category, String author, String publishedDate, int takenBy) {
        this.name = name;
        this.category = category;
        this.author = author;
        this.publishedDate = publishedDate;
        this.takenBy = takenBy;
    }

    public Books() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    public int getTakenBy() {
        return takenBy;
    }

    public void setTakenBy(int takenBy) {
        this.takenBy = takenBy;
    }
}
