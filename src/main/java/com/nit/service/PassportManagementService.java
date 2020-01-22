package com.nit.service;

import java.util.List;
import java.util.Optional;

import com.nit.entity.EducationalDetailsEntity;
import com.nit.entity.PersonEntity;
import com.nit.model.EducationModel;
import com.nit.model.PassportDetailsModel;
import com.nit.model.PersonModel;

public interface PassportManagementService {
	
	public int insertRecords(PersonModel pmodel);
	
	public List<String> allDegres();
	
	public List<String> alluniversity();
	
	public List<Integer> allYear();
	
	public Optional<PersonEntity> getdataByID(Integer id);
	
	public EducationModel insertValue(EducationModel emodel);
	
	public Optional<EducationalDetailsEntity> geteducationdataByID(Integer id);
	
	public PassportDetailsModel savePassportDetailsWithPassportNumber(PassportDetailsModel pmodel);

}
