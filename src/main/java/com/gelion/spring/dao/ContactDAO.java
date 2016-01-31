package com.gelion.spring.dao;

import java.util.List;

import com.gelion.spring.model.Contact;

public interface ContactDAO {

	public void addContact(Contact p);
	public void updateContact(Contact p);
	public List<Contact> listContacts();
	public Contact getContactById(int id);
	public void removeContact(int id);
}
