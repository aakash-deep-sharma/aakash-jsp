package com.app.demo.service;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.demo.dao.ContactDao;
import com.app.demo.model.Contact;

@Service("contact_dao_service")
@Transactional
public class ContactServiceDaoImpl implements ContactService {
	@Autowired
	private ContactDao dao;
	
	@PostConstruct
	public void init()
	{
		System.out.println("in service init "+dao);
	}

	@Transactional(readOnly=true)
	@Override
	public Contact validateContact(String email, String pass) throws Exception {
		Contact c1=dao.validateContact(email, pass);
		System.out.println(c1.getHobbies().size());
		return c1;
	}

	@Override
	public Contact registerContact(Contact c) throws Exception {
		
		
		return dao.registerContact(c);
	}

	@Override
	public String updateContact(Contact c) throws Exception {
		
		return dao.updateContact(c);
	}

	@Override
	public String deleteContact(Contact c) throws Exception {
		
		return dao.deleteContact(c);
	}
	

}
