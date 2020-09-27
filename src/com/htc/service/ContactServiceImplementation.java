package com.htc.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.htc.beans.ContactInfo;
import com.htc.dao.ContactDAO;

@Service
public class ContactServiceImplementation implements ContactService
{
	
	@Autowired
	ContactDAO contactDAO;
	
	@Override
	public boolean addContact(ContactInfo contactInfo) {
		// TODO Auto-generated method stub
		return contactDAO.addContactDAO(contactInfo);
	}

	@Override
	public ContactInfo getContact(String contactName) {
		// TODO Auto-generated method stub
		return contactDAO.getContactDAO(contactName);
	}

	@Override
	public List<ContactInfo> getAllContacts() {
		// TODO Auto-generated method stub
		return contactDAO.getAllContactsDAO();
	}
	
}

