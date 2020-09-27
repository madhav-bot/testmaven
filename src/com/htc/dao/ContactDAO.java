package com.htc.dao;

import java.util.List;

import com.htc.beans.ContactInfo;

public interface ContactDAO 
{
	public boolean addContactDAO(ContactInfo contactInfo);
	
	public ContactInfo getContactDAO(String contactName);
	
	public List<ContactInfo> getAllContactsDAO();
}

