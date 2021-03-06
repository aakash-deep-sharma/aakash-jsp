package com.app.demo.service;

import com.app.demo.model.Contact;

public interface ContactService {
	Contact validateContact(String email, String pass) throws Exception;
	Contact registerContact(Contact c) throws Exception;
	String updateContact(Contact c) throws Exception;
	String deleteContact(Contact c) throws Exception;

}
