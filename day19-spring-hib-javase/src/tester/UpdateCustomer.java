package tester;

import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.app.demo.model.Contact;
import com.app.demo.service.ContactService;

public class UpdateCustomer {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in);
				ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
						"spring-config.xml")) {
			System.out.println("sc started");
			// get service bean
			ContactService service = ctx.getBean("contact_dao_service",
					ContactService.class);
			System.out.println("Enter contact details to be update -- em nm pass amt");
			Contact transientContact = new Contact(sc.next(), sc.next(),
					sc.next(), sc.nextDouble(), new Date(), "male", "IN",
					Arrays.asList("dance", "sketching"));
			System.out.println("Enter contact id");
			transientContact.setId(sc.nextInt());
			System.out.println("reg cust details "
					+ service.updateContact(transientContact));

		} catch (Exception e) {
			e.printStackTrace();
		}


	}

}
