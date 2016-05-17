package tester;

import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.app.demo.model.Contact;
import com.app.demo.service.ContactService;

public class DeleteCustomer {

	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in);
				ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
						"spring-config.xml")) {
			System.out.println("sc started");
			// get service bean
			ContactService service = ctx.getBean("contact_dao_service",
					ContactService.class);
			
			Contact transientContact = new Contact();
			System.out.println("Enter contact id");
			transientContact.setId(sc.nextInt());
			System.out.println("reg cust details "
					+ service.deleteContact(transientContact));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
