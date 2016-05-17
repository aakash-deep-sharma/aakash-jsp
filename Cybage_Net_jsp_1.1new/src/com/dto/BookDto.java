package com.dto;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.dao.AdminDao;
import com.dao.UserDao;


public class BookDto {

	private int bookId;
	private String bookName;
	private String bookAuthor;
	private double bookPrice;
	private String bookReview;
	private UserDao userDao;
	private AdminDao adminDao;
	
	public BookDto() {
		
	}
	
	public BookDto(int bId, String BookName, String bAuthor, double bPrice) {
		super();
		this.bookId = bId;
		this.bookName = BookName;
		this.bookAuthor = bAuthor;
		this.bookPrice = bPrice;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bId) {
		this.bookId = bId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String BookName) {
		this.bookName = BookName;
	}
	public String getBookAuthor() {
		return bookAuthor;
	}
	public void setBookAuthor(String bAuthor) {
		this.bookAuthor = bAuthor;
	}
	public double getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(double bPrice) {
		this.bookPrice = bPrice;
	}
	
	public String getBookReview() {
		return bookReview;
	}

	public void setBookReview(String bookReview) {
		System.out.println("1");
		this.bookReview = bookReview;
	}
	
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	public AdminDao getAdminDao() {
		return adminDao;
	}

	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}

	@Override
	public String toString() {
		return "BookDto [bId=" + bookId + ", BookName=" + bookName + ", bAuthor="
				+ bookAuthor + ", bPrice=" + bookPrice + "]";
	}
	
	public List<BookDto> getSearchBooks() throws SQLException
	{
			return userDao.searchBook(bookName);	
	}
	
	
	public String getAddBook() throws SQLException
	{
		int maxId = adminDao.maxBookId();
		return adminDao.addBook(maxId, bookName,bookAuthor, bookPrice);
	}
	public List<String> getShowReviews() throws SQLException
	{
		return userDao.showReview(bookId);
	}
	
	public BookDto getBook() throws SQLException
	{
		return userDao.getBook(bookId);
	}
	
	public String getAddReview() throws SQLException
	{
		System.out.println("2");
		return userDao.addReview(bookId, bookReview);
	}
	
}