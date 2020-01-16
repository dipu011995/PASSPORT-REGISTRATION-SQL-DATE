package com.pk.controller;

import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pk.domain.EducationDetails;
import com.pk.domain.PersonDetails;
import com.pk.service.PassportMgmtService;

@Controller
public class EducationalDetailsController {

	@Autowired
	private PassportMgmtService service;
	
	@RequestMapping(value = "/eduDetails")
	public String displayEducationalDetails(HttpServletRequest req,Model model) {
		
		int pid = Integer.parseInt(req.getParameter("pid"));
		
		EducationDetails eduDetails = new EducationDetails();
		eduDetails.setPid(pid);
		
		List<String> degreeList = service.getAllDegree();
		model.addAttribute("degreeList", degreeList);
		
		List<String> universityList = service.getAllUniversity();
		model.addAttribute("unvrList", universityList);
		
		List<String> passoutYearList = service.getAllPassoutYear();
		model.addAttribute("yearList", passoutYearList);		
		
		model.addAttribute("educationalDetails", eduDetails);
		
		return "educational_details";
	}
	
	@PostMapping(value = "/saveEduDtls")
	public String handelSubmitButton(@ModelAttribute("educationalDetails")EducationDetails eduDetails,Model model) {
		
		int educationId = service.saveEducationDetails(eduDetails);
		
		return "redirect:/appReview?eduId="+educationId;
	}
	
	@RequestMapping(value = "/editPersonDtls",method = RequestMethod.GET)
	public String editPersonDetails(HttpServletRequest req,Model model) throws ParseException {
		int personId = Integer.parseInt(req.getParameter("perId"));
		
		PersonDetails persnDtls= service.getPersonDetailsById(personId);
		
		model.addAttribute("personDetails", persnDtls);
		
		return "person_details";
		
	}
}


//java.util.Date dobUtilDate = new java.util.Date(persnDtls.getDob().getTime());
//
//System.out.println(dobUtilDate);
//
//SimpleDateFormat sm = new SimpleDateFormat("MM-dd-yyyy");
//
//String format = sm.format(dobUtilDate);


//persnDtls.setDob(date);
//System.out.println(persnDtls);


//SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//
//String dateString = format.format( new Date()   );
//Date   date       = format.parse ( "2009-12-31" );    
//


// LocalDateTime ldt=dobUtilDate.toInstant()
//         .atZone(ZoneId.systemDefault())
//         .toLocalDateTime();
//
//LocalDateTime ldt = LocalDateTime.now();
//System.out.println("idt::"+ldt);

//System.out.println(DateTimeFormatter.ofPattern("MM-dd-yyyy", Locale.ENGLISH).format(ldt));
//String format2 = DateTimeFormatter.ofPattern("MM-dd-yyyy", Locale.ENGLISH).format(ldt);


//DateTimeFormatter f = DateTimeFormatter.ofPattern( "MM/dd/yyyy" );
//LocalDate ld = LocalDate.parse( "01/10/2010" , f );
//System.out.println("ld::"+ld);



//DateFormat sourceFormat = new SimpleDateFormat("MM-dd-yyyy");
//String dateAsString = "25/12/2010";
//Date date = sourceFormat.parse(dateAsString);

