package tester;

import hib_pojos.Book;

import java.util.List;
import java.util.Scanner;

import dao.BookDao;
import dao.BookDaoImpl;
import utils.HibernateUtils;

public class GetBooks {

	public static void main(String[] args) {
		try  {
			HibernateUtils.getFactory();
			
			BookDao dao = new BookDaoImpl();
			List<Book> books= dao.getBooks();
			System.out.println(books);
		

		} catch (Exception e) {
			e.printStackTrace();
		}
		HibernateUtils.getFactory().close();

	}

}
