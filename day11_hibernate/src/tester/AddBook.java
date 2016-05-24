package tester;

import hib_pojos.Book;

import java.util.Date;
import java.util.Scanner;

import dao.BookDao;
import dao.BookDaoImpl;
import utils.HibernateUtils;

public class AddBook {

	public static void main(String[] args) {
		// SF
		HibernateUtils.getFactory();// config n sf -- created
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter Book details  -title author price qty");
			Book b1 = new Book(sc.next(), sc.next(), sc.nextDouble(),
					sc.nextInt(), new Date());
			BookDao dao = new BookDaoImpl();
			System.out.println("Book added with ID " + dao.addBook(b1));

		} catch (Exception e) {
			e.printStackTrace();
		}

		HibernateUtils.getFactory().close();// cn pool is destroyed
	}
}
