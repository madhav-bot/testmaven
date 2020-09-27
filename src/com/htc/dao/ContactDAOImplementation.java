package com.htc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.htc.beans.ContactInfo;

@Repository
public class ContactDAOImplementation implements ContactDAO
{
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public boolean addContactDAO(ContactInfo contactInfo) {
		// TODO Auto-generated method stub
		boolean status=false;
		String sql="INSERT INTO contact VALUES(?,?,?,?,?,?)";
		int output=jdbcTemplate.update(sql, contactInfo.getContactName(),contactInfo.getPhoneNumber(),contactInfo.getEmailId(),contactInfo.getCityName(),contactInfo.getStateName(),contactInfo.getPincodeData());
		if(output>0)
		{
			status=true;
		}
		return status;
	}

	@Override
	public ContactInfo getContactDAO(String contactName) {
		// TODO Auto-generated method stub
		ContactInfo contactInfo=null;
		try 
		{
		String sql="SELECT contact_name,phone_number,email,city_name,state_name,pincode FROM contact WHERE contact_name=?";
		contactInfo=jdbcTemplate.queryForObject(sql, new Object[] {contactName}, new RowMapper<ContactInfo>() {

			@Override
			public ContactInfo mapRow(ResultSet resultSet, int rowNumber) throws SQLException {
				// TODO Auto-generated method stub
				ContactInfo contactInfo=new ContactInfo();
				contactInfo.setContactName(resultSet.getString(1));
				contactInfo.setPhoneNumber(resultSet.getString(2));
				contactInfo.setEmailId(resultSet.getString(3));
				contactInfo.setCityName(resultSet.getString(4));
				contactInfo.setStateName(resultSet.getString(5));
				contactInfo.setPincodeData(resultSet.getString(6));
				return contactInfo;
			}
			
		});
		}
		catch (Exception exception) 
		{
			// TODO: handle exception
			contactInfo=null;
		}
		return contactInfo;
	}

	@Override
	public List<ContactInfo> getAllContactsDAO() {
		// TODO Auto-generated method stub
		String sql="SELECT contact_name,phone_number,email,city_name,state_name,pincode FROM contact";
		List<ContactInfo> listContactInfo=jdbcTemplate.query(sql, new RowMapper<ContactInfo>() {

			@Override
			public ContactInfo mapRow(ResultSet resultSet, int rowNumber) throws SQLException {
				// TODO Auto-generated method stub

				ContactInfo contactInfo=new ContactInfo();
				contactInfo.setContactName(resultSet.getString(1));
				contactInfo.setPhoneNumber(resultSet.getString(2));
				contactInfo.setEmailId(resultSet.getString(3));
				contactInfo.setCityName(resultSet.getString(4));
				contactInfo.setStateName(resultSet.getString(5));
				contactInfo.setPincodeData(resultSet.getString(6));
				return contactInfo;
			}
			
		});
		return listContactInfo;
	}
	
}
