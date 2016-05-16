package tester;

import java.util.Scanner;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.app.demo.service.ContactService;

public class ValidateCustomer {

	public ValidateCustomer() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in);
				ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
						"spring-config.xml")) {
			System.out.println("sc started");
			// get service bean
			ContactService service = ctx.getBean("contact_dao_service",
					ContactService.class);
			System.out.println("Enter email n password");
			System.out.println("cust details "
					+ service.validateContact(sc.next(), sc.next()));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
