package tester;

import hib_pojos.Book;

import java.util.Scanner;

import dao.BookDao;
import dao.BookDaoImpl;
import utils.HibernateUtils;

public class GetBookById {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			HibernateUtils.getFactory();
			System.out.println("Enter Book Id");
			BookDao dao = new BookDaoImpl();
			Book ref = dao.getBookById(sc.nextInt());
			if (ref == null)
				System.out.println("Book not found....");
			else
				System.out.println("Book dtls " + ref);

		} catch (Exception e) {
			e.printStackTrace();
		}
		HibernateUtils.getFactory().close();

	}

}
