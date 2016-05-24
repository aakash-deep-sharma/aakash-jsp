package dao;

import java.util.List;

import hib_pojos.Book;

public interface BookDao {
	Integer addBook(Book b1) throws Exception;
	Book getBookById(Integer bookId) throws Exception;
	List<Book> getBooks() throws Exception;

}
