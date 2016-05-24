package hib_pojos;

import java.util.Date;
import javax.persistence.*;

@Entity
// mandatory -- hib frmwork -- at start up time
// to specify which class to be auto persisted
@Table(name = "dac_books")
public class Book {

	private Integer bookId;
	private String title;
	private String author;
	private double price;
	private int quantity;
	private Date publishDate;

	public Book() {
		System.out.println("in book constr");
	}

	public Book(String title, String author, double price, int quantity,
			Date publishDate) {
		super();
		this.title = title;
		this.author = author;
		this.price = price;
		this.quantity = quantity;
		this.publishDate = publishDate;
	}

	@Id
	// mandatory
	@GeneratedValue
	@Column(name="bk_id")
	// to specify to hib to choose suitable native(db specific) id generation
	// policy  eg -- oracle --int sequence , MYSQL -- auto inc 
	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
	@Column(length=20,unique=true)
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	@Column(length=20)
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	@Column(columnDefinition="decimal(6,1)")
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Temporal(TemporalType.DATE)
	@Column(name="pub_date")
	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", title=" + title + ", author="
				+ author + ", price=" + price + ", quantity=" + quantity
				+ ", publishDate=" + publishDate + "]";
	}

}
