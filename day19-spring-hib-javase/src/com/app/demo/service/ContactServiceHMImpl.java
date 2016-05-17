package com.app.demo.service;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.app.demo.model.Contact;

@Service("hm_service")
public class ContactServiceHMImpl implements ContactService {
	private HashMap<String, Contact> contacts;

	public ContactServiceHMImpl() {
		System.out.println("in hm service constr");
		contacts = new HashMap<>();
		contacts.put("a@gmail", new Contact("a@gmail", "a", "a#123", 500,
				new Date(), "female", "IN", Arrays.asList("music", "reading")));
	}

	@Override
	public Contact validateContact(String email, String pass) throws Exception {
		synchronized (contacts) {

			if (contacts.containsKey(email)) {
				Contact c = contacts.get(email);
				if (c.getPassword().equals(pass))
					return c;
			}
			return null;
		}
	}

	@Override
	public Contact registerContact(Contact c) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateContact(Contact c) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteContact(Contact c) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	

}
