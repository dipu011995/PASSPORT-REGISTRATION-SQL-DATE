package com.pk.service;

import java.util.List;

import com.pk.domain.EducationDetails;
import com.pk.domain.PassportDetails;
import com.pk.domain.PersonDetails;

public interface PassportMgmtService {
	
	public int savePrsnDtlsForPassport(PersonDetails perDtls);
	
	public List<String> getAllDegree();
	
	public List<String> getAllUniversity();
	
	public List<String> getAllPassoutYear();
	
	public PersonDetails getPersonDetailsById(Integer pid);
	
	public int saveEducationDetails(EducationDetails eduDetails);
	
	public PassportDetails getEducationalDetailsById(Integer pid);
	
	public String savePasspostDetails(Integer pid);
	
}
