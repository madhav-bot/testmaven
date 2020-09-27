package com.htc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.htc.beans.ContactInfo;
import com.htc.service.ContactService;
import com.htc.validator.ContactDataValidator;

@Controller   
public class ContactDataController {
	@Autowired
	ContactService contactService;

	@Autowired
	ContactDataValidator validator;

	@RequestMapping(value = "/addContact", method = RequestMethod.GET)
	public ModelAndView navigateToAddContactForm()
	{
		ModelAndView modelAndView = new ModelAndView("addContactForm");
		modelAndView.addObject("contact", new ContactInfo());
		return modelAndView;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView addContactData(@Validated @ModelAttribute("contact") ContactInfo contactInfo, BindingResult bindingResult, RedirectAttributes redirectAttributes)
	{
		ModelAndView modelAndView=null;
		boolean addingStatus = false;
		validator.validate(contactInfo, bindingResult);
		if (bindingResult.hasErrors()) 
		{
			modelAndView=new ModelAndView("addContactForm");
			return modelAndView;
		} 
		else 
		{
			addingStatus = contactService.addContact(contactInfo);
			if (addingStatus)
			{
				//redirectAttributes.addFlashAttribute("message", "The Contact was saved Successfully");
				//redirectAttributes.addFlashAttribute("contactName", contactInfo.getContactName());
				//return "redirect:/addOnSuccess";
				 modelAndView = new ModelAndView("addOnSuccess", "contact", contactInfo);
				return modelAndView;
			}
			else
			{
				//return "redirect:/addOnFailure";
				modelAndView = new ModelAndView("addOnFailure", "contact", contactInfo);
				return modelAndView;
			}
		}
	}

	@RequestMapping(value = "/searchContact", method = RequestMethod.GET)
	public ModelAndView navigateToViewContactForm() 
	{
		ModelAndView modelAndView = new ModelAndView("viewContactDataForm");
		modelAndView.addObject("contact", new ContactInfo());
		return modelAndView;
	}

	@RequestMapping(value = "/view", method = RequestMethod.POST)
	public ModelAndView viewContactDataForm(@RequestParam("contactName") String contactName)
	{
		ModelAndView modelAndView = null;
		ContactInfo contactInfo = contactService.getContact(contactName);
		if (contactInfo != null)
		{
			modelAndView = new ModelAndView("viewDataOnSuccess", "contact", contactInfo);
		} 
		else 
		{
			//modelAndView = new ModelAndView("viewDataOnFailure");
			//modelAndView.addObject("data", contactName);
			throw new NullPointerException("Null Pointer Exception");
		}
		return modelAndView;
	}

	@RequestMapping(value = "/listContacts", method = RequestMethod.GET)
	public ModelAndView navigateToViewAllContacts()
	{
		List<ContactInfo> list = contactService.getAllContacts();
		ModelAndView modelAndView = new ModelAndView("viewAllContacts", "list", list);
		return modelAndView;
	}
	
	@ExceptionHandler(value=NullPointerException.class)
	public ModelAndView exceptionDataHandler(Exception exception)
	{
		ModelAndView modelAndView=new ModelAndView("viewDataOnFailure");
		modelAndView.addObject("exceptionData", exception.getMessage());
		return modelAndView;
	}
}
