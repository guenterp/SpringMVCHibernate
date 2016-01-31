package com.gelion.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.gelion.spring.model.Contact;

@Repository
public class ContactDAOImpl implements ContactDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(ContactDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public void addContact(Contact p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);
		logger.info("Contact saved successfully, Contact Details="+p);
	}

	@Override
	public void updateContact(Contact p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		logger.info("Contact updated successfully, Contact Details="+p);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Contact> listContacts() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Contact> contactsList = session.createQuery("from Contact").list();
		for(Contact p : contactsList){
			logger.info("Contact List::"+p);
		}
		return contactsList;
	}

	@Override
	public Contact getContactById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		Contact p = (Contact) session.load(Contact.class, new Integer(id));
		logger.info("Contact loaded successfully, Contact details="+p);
		return p;
	}

	@Override
	public void removeContact(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Contact p = (Contact) session.load(Contact.class, new Integer(id));
		if(null != p){
			session.delete(p);
		}
		logger.info("Contact deleted successfully, contact details="+p);
	}

}
