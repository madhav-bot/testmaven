package com.htc.validator;

import java.util.regex.Pattern;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import com.htc.beans.ContactInfo;

@Component
public class ContactDataValidator implements Validator
{

	@Override
	public boolean supports(Class<?> class9) {
		// TODO Auto-generated method stub
		return ContactInfo.class.equals(class9);
	}

	@Override
	public void validate(Object targetObject, Errors errors) {
		// TODO Auto-generated method stub
		ContactInfo contactInfo=(ContactInfo)targetObject;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "contactName", "contactName.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phoneNumber", "phoneNumber.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "emailId", "emailId.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cityName", "cityName.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "stateName", "stateName.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pincodeData", "pincodeData.required");
		
		try
		{
		String phoneNumber=contactInfo.getPhoneNumber();
		String phoneNumberRegEx="^(7|8|9)[0-9]{9}$";
		Pattern pattern=Pattern.compile(phoneNumberRegEx);
		boolean phoneNumberStatus=pattern.matcher(phoneNumber).matches();
		if(!phoneNumberStatus)
		{
			errors.rejectValue("phoneNumber", "phoneNumber.mismatchdata");
		}
		}
		catch(Exception exception)
		{
			errors.reject("phoneNumber", "phoneNumber.invaliddata");
		}
		
		try
		{
		String emailId=contactInfo.getEmailId();
		String emailIdRegEx="^[a-zA-Z0-9]+@[a-zA-Z]+\\.[a-z]{3}$";
		Pattern pattern=Pattern.compile(emailIdRegEx);
		boolean emailIdStatus=pattern.matcher(emailId).matches();
		if(!emailIdStatus)
		{
			errors.rejectValue("emailId", "emailId.mismatchdata");
		}
		}
		catch(Exception exception)
		{
			errors.reject("emailId", "emailId.invaliddata");
		}
	}
	
}
