package com.gelion.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gelion.spring.model.Contact;
import com.gelion.spring.dao.ContactDAO;

@Service
public class ContactServiceImpl implements ContactService {
	
	private ContactDAO contactDAO;

	public void setContactDAO(ContactDAO contactDAO) {
		this.contactDAO = contactDAO;
	}

	@Override
	@Transactional
	public void addContact(Contact p) {
		this.contactDAO.addContact(p);
	}

	@Override
	@Transactional
	public void updateContact(Contact p) {
		this.contactDAO.updateContact(p);
	}

	@Override
	@Transactional
	public List<Contact> listContacts() {
		return this.contactDAO.listContacts();
	}

	@Override
	@Transactional
	public Contact getContactById(int id) {
		return this.contactDAO.getContactById(id);
	}

	@Override
	@Transactional
	public void removeContact(int id) {
		this.contactDAO.removeContact(id);
	}

}
