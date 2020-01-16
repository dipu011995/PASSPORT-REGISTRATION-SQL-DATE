package com.pk.controller;



import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pk.domain.PassportDetails;
import com.pk.service.PassportMgmtService;

@Controller
public class ApplicationReviewController {
	
	@Autowired
	private PassportMgmtService passportService;
	
//	@RequestMapping(value = "/appReview")
//	public String displayApplicationReviewForm(HttpServletRequest req,Model model) {
//		
//		int educationId = Integer.parseInt(req.getParameter("eduId"));
//		
//		 EducationalDetailsEntity edEntity = passportService.getEducationalDetailsById(educationId);
//		
//		 EducationDetails eduDetails = new EducationDetails();
//		 
//		 BeanUtils.copyProperties(edEntity, eduDetails);
//		 
//		 eduDetails.setPid(edEntity.getPerDtlsEntity().getPid());
//		 
//	
//		 PersonDetailsEntity perEntity = edEntity.getPerDtlsEntity();
////		 BeanUtils.copyProperties(perEntity, edEntity.getPerDtlsEntity());		 
//		 
//		 PersonDetails perDetails = new PersonDetails();
//		 BeanUtils.copyProperties(perEntity, perDetails);
//		 
//		 PassportDetails passportDetails = new PassportDetails();
//		 
//		 BeanUtils.copyProperties(eduDetails, passportDetails);
//		 BeanUtils.copyProperties(perDetails, passportDetails);
//		 
//		 model.addAttribute("passportDetails", passportDetails);
//		return "application_review";
//	}
	
	
	
	@RequestMapping(value = "/appReview")
	public String displayApplicationReviewForm(HttpServletRequest req,Model model) {
		System.out.println("ApplicationReviewController.displayApplicationReviewForm()");
		int educationId = Integer.parseInt(req.getParameter("eduId"));
		
		  PassportDetails passportDetails = passportService.getEducationalDetailsById(educationId);
		
		 
		 model.addAttribute("passportDetails", passportDetails);
		return "application_review";
	}
	
	@RequestMapping(value = "/savePssportDetails",method = RequestMethod.POST)
	public String savePassportDetails(@ModelAttribute("passportDetails")PassportDetails passDetails,Model model) {
		
		  String passportNum= passportService.savePasspostDetails(passDetails.getPid());

		  if(passportNum!=null)
			model.addAttribute("passportNum", passportNum);
			  return "result";
		
	}

}
