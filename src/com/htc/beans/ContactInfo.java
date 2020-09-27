package com.htc.beans;

public class ContactInfo 
{
	private String contactName;
	private String phoneNumber;
	private String emailId;
	private String cityName;
	private String stateName;
	private String pincodeData;
	
	public ContactInfo()
	{
		
	}

	public ContactInfo(String contactName, String phoneNumber, String emailId, String cityName, String stateName,
			String pincodeData) {
		super();
		this.contactName = contactName;
		this.phoneNumber = phoneNumber;
		this.emailId = emailId;
		this.cityName = cityName;
		this.stateName = stateName;
		this.pincodeData = pincodeData;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getPincodeData() {
		return pincodeData;
	}

	public void setPincodeData(String pincodeData) {
		this.pincodeData = pincodeData;
	}

	@Override
	public String toString() {
		return "ContactInfo [contactName=" + contactName + ", phoneNumber=" + phoneNumber + ", emailId=" + emailId
				+ ", cityName=" + cityName + ", stateName=" + stateName + ", pincodeData=" + pincodeData + "]";
	}
		
}
