package ada.edu.midterm.library.model.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "bookAndUser")
public class BookAndUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int userId;
    private int bookId;
    private Date pickUpTime;
    private Date dropOffTime;

    public BookAndUser(int id, int userId, int bookId, Date pickUpTime, Date dropOffTime) {
        this.id = id;
        this.userId = userId;
        this.bookId = bookId;
        this.pickUpTime = pickUpTime;
        this.dropOffTime = dropOffTime;
    }

    public BookAndUser() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public Date getPickUpTime() {
        return pickUpTime;
    }

    public void setPickUpTime(Date pickUpTime) {
        this.pickUpTime = pickUpTime;
    }

    public Date getDropOffTime() {
        return dropOffTime;
    }

    public void setDropOffTime(Date dropOffTime) {
        this.dropOffTime = dropOffTime;
    }
}
