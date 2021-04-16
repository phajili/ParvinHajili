package ada.edu.midterm.library.model.dto;

import ada.edu.midterm.library.model.entity.Books;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data

public class BookModel
{
	private long id;
	private String name;
	private String category;
	private String author;
	private String publishedDate;
	private int takenBy;
	private List<CommentModel> comments;
	
	public BookModel(Books book)
	{
		this.id = book.getId();
		this.name = book.getName();
		this.category = book.getCategory();
		this.author = book.getAuthor();
		this.publishedDate = book.getPublishedDate();
		this.takenBy = book.getTakenBy();
	}
	
	public void setComments(List<CommentModel> comments)
	{
		this.comments = comments;
	}
}
