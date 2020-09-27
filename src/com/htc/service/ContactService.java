package com.htc.service;

import java.util.List;

import com.htc.beans.ContactInfo;

public interface ContactService 
{
	public boolean addContact(ContactInfo contactInfo);

	public ContactInfo getContact(String contactName);
	
	public List<ContactInfo> getAllContacts();
}
