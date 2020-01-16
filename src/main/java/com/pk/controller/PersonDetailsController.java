package com.pk.controller;


import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pk.domain.PersonDetails;
import com.pk.service.PassportMgmtService;

@Controller
public class PersonDetailsController {
	
	@Autowired
	PassportMgmtService passportService;
	
	@RequestMapping(value = "/")
	public String displayPersonDetailsForm(Model model) {
		
		PersonDetails pernDetails = new PersonDetails(); 
		model.addAttribute("personDetails", pernDetails);
		
		return "person_details";
	}
	
	@PostMapping(value = "/savePerson")
	public String hndlSubmitButton(@ModelAttribute("personDetails")PersonDetails perDtls,HttpServletRequest req) throws ParseException {
		
		int pid = passportService.savePrsnDtlsForPassport(perDtls);
		
			return "redirect:/eduDetails?pid="+pid ;
	}
	
}
