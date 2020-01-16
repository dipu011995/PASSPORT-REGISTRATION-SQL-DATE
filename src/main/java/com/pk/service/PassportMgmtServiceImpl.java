package com.pk.service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pk.domain.EducationDetails;
import com.pk.domain.PassportDetails;
import com.pk.domain.PersonDetails;
import com.pk.entity.EducationalDetailsEntity;
import com.pk.entity.PassportAppDetailsEntity;
import com.pk.entity.PersonDetailsEntity;
import com.pk.repositeries.EducationalDetailsRepositeries;
import com.pk.repositeries.HighestDegreeRepositeries;
import com.pk.repositeries.PassportRepositeries;
import com.pk.repositeries.PersonDetailsRepositeries;
import com.pk.repositeries.UniversityRepositeries;
import com.pk.repositeries.YearRepositeries;

@Service
public class PassportMgmtServiceImpl implements PassportMgmtService {

	@Autowired
	private PersonDetailsRepositeries personRepositeries;

	@Autowired
	private HighestDegreeRepositeries degreeRepositeries;

	@Autowired
	private UniversityRepositeries univerRepositeries;

	@Autowired
	private YearRepositeries yearRepositeries;

	@Autowired
	private EducationalDetailsRepositeries eduRepositeries;

	@Autowired
	private PassportRepositeries passportRepositeries;

	@Override
	public int savePrsnDtlsForPassport(PersonDetails perDtls) {
		PersonDetailsEntity perEntity = new PersonDetailsEntity();
		BeanUtils.copyProperties(perDtls, perEntity);

		PersonDetailsEntity savePerEntity = personRepositeries.save(perEntity);

		return savePerEntity.getPid();
	}

	@Override
	public List<String> getAllDegree() {
		return degreeRepositeries.findAllDegrees();
	}

	@Override
	public List<String> getAllUniversity() {
		return univerRepositeries.findAllUniversitiesNames();
	}

	@Override
	public List<String> getAllPassoutYear() {
		return yearRepositeries.findAllpassoutYears();
	}

	@Override
	public PersonDetails getPersonDetailsById(Integer pid) {
		PersonDetailsEntity personEntity = null;

		Optional<PersonDetailsEntity> optEntity = personRepositeries.findById(pid);

		if (optEntity != null) {
			personEntity = optEntity.get();
		}

		PersonDetails personDetails = new PersonDetails();

		BeanUtils.copyProperties(personEntity, personDetails);

		return personDetails;
	}

	@Override
	public int saveEducationDetails(EducationDetails eduDetails) {

		EducationalDetailsEntity eduEntity = new EducationalDetailsEntity();

		BeanUtils.copyProperties(eduDetails, eduEntity);

		PersonDetailsEntity pe = new PersonDetailsEntity();
		pe.setPid(eduDetails.getPid());
		eduEntity.setPerDtlsEntity(pe);

		EducationalDetailsEntity saveEduEntity = eduRepositeries.save(eduEntity);

		return saveEduEntity.getEid();
	}

//	@Override
//	public PassportDetails getEducationalDetailsById(Integer eduId) {
//		EducationalDetailsEntity eduEntity = null;
//		Optional<EducationalDetailsEntity> optEntity = eduRepositeries.findById(eduId);
//		if (optEntity != null) {
//			eduEntity = optEntity.get();
//		}
//		EducationDetails eduDetails = new EducationDetails();
//		BeanUtils.copyProperties(eduEntity, eduDetails);
//
////		eduDetails.setPid(edEntity.getPerDtlsEntity().getPid());
//		PersonDetailsEntity perEntity = eduEntity.getPerDtlsEntity();
////			 BeanUtils.copyProperties(perEntity, edEntity.getPerDtlsEntity());		 
//
//		PersonDetails perDetails = new PersonDetails();
//		BeanUtils.copyProperties(perEntity, perDetails);
//		PassportDetails passportDetails = new PassportDetails();
//		BeanUtils.copyProperties(eduDetails, passportDetails);
//		BeanUtils.copyProperties(perDetails, passportDetails);
//	
//		return passportDetails;
//	}

	@Override
	public PassportDetails getEducationalDetailsById(Integer eduId) {

		EducationalDetailsEntity eduEntity = null;
		Optional<EducationalDetailsEntity> optEntity = eduRepositeries.findById(eduId);
		if (optEntity != null) {
			eduEntity = optEntity.get();
		}
		PassportDetails passportDetails = new PassportDetails();

		BeanUtils.copyProperties(eduEntity, passportDetails);
		BeanUtils.copyProperties(eduEntity.getPerDtlsEntity(), passportDetails);

		return passportDetails;
	}

	@Override
	public String savePasspostDetails(Integer pid) {

		PassportAppDetailsEntity passEntity = new PassportAppDetailsEntity();

		passEntity.setPassportNumber(generatePassportNumber());

		PersonDetailsEntity pe = new PersonDetailsEntity();
		pe.setPid(pid);
		passEntity.setPerDtlsEntity(pe);

		PassportAppDetailsEntity saveEntity = passportRepositeries.save(passEntity);
		if (saveEntity != null)
			return saveEntity.getPassportNumber();
		else
			return null;
	}

	public String generatePassportNumber() {
		Random r = new Random();
		char c = (char) (r.nextInt(26) + 'a');
		int aNumber = 0;
		aNumber = (int) ((Math.random() * 9000000) + 1000000);
		return c + "" + aNumber;
	}
}
