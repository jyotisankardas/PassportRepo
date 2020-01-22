package com.nit.service;

import java.security.SecureRandom;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nit.entity.EducationalDetailsEntity;
import com.nit.entity.PassportAppDtlsEntity;
import com.nit.entity.PersonEntity;
import com.nit.model.EducationModel;
import com.nit.model.PassportDetailsModel;
import com.nit.model.PersonModel;
import com.nit.repositery.DegreeRepositery;
import com.nit.repositery.EducationalRepositery;
import com.nit.repositery.PassportAppDetailsRepository;
import com.nit.repositery.PersonRepo;
import com.nit.repositery.UniversitiesRepository;
import com.nit.repositery.YearRepositery;

@Service
public class PassportManagementServiceimpl implements PassportManagementService {

	@Autowired
	private PersonRepo prepo;

	@Autowired
	private DegreeRepositery drepo;

	@Autowired
	private UniversitiesRepository urepo;

	@Autowired
	private YearRepositery yrepo;

	@Autowired
	private EducationalRepositery erepo;

	@Autowired
	private PassportAppDetailsRepository passAppRepo;

	static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZ";
	static SecureRandom rnd = new SecureRandom();

	/**
	 * This method is used for insert record
	 */
	@Override
	public int insertRecords(PersonModel pmodel) {
		PersonEntity entity = new PersonEntity();
		BeanUtils.copyProperties(pmodel, entity);

		PersonEntity save = prepo.save(entity);
		return save.getPersonId();
	}

	/**
	 * This method is used for get all degrees
	 */
	public List<String> allDegres() {
		return drepo.getDegrees();
	}

	/**
	 * This method is used for get all university
	 */
	public List<String> alluniversity() {
		return urepo.getUniversities();
	}

	/**
	 * This method is used for get all year
	 */
	public List<Integer> allYear() {
		return yrepo.getYears();
	}

	/**
	 * this method is used for get all data by id in Person Repositery entity
	 */
	public Optional<PersonEntity> getdataByID(Integer id) {
		return prepo.findById(id);
	}

	/**
	 * This method is used for insert education details record in EducationalDetails
	 * entity
	 */
	public EducationModel insertValue(EducationModel emodel) {
		EducationalDetailsEntity entity = new EducationalDetailsEntity();
		PersonEntity pEntity=new PersonEntity();
		BeanUtils.copyProperties(emodel, entity);
		pEntity.setPersonId(emodel.getPersonId());
		entity.setEntity(pEntity);
		if (entity != null) {
			EducationalDetailsEntity save = erepo.save(entity);
			BeanUtils.copyProperties(save, emodel);
		emodel.setPersonId(save.getEntity().getPersonId());
			System.out.println(save);
			System.out.println(emodel);
		}
		return emodel;
	}

	/**
	 * This method is used for get educationaldetails by id
	 */
	public Optional<EducationalDetailsEntity> geteducationdataByID(Integer id) {
		return erepo.findById(id);

	}

	/**
	 * this method is used for savePassportDetailsWithPassportNumber
	 */
	@Override
	public PassportDetailsModel savePassportDetailsWithPassportNumber(PassportDetailsModel pmodel) {
		pmodel.setPassportNumber(generateRandomPassword(8));
		PassportAppDtlsEntity entity = new PassportAppDtlsEntity();
		BeanUtils.copyProperties(pmodel, entity);
		
		PersonEntity pentity=new PersonEntity();
		pentity.setPersonId(pmodel.getPersonId());
		entity.setEntity(pentity);
		
		entity = passAppRepo.save(entity);
		if (entity != null)
			BeanUtils.copyProperties(entity, pmodel);
		return pmodel;
	}
/**
 * This method is used for generate Random password
 * @param len
 * @return
 */
	private String generateRandomPassword(int len) {
		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++)
			sb.append(AB.charAt(rnd.nextInt(AB.length())));
		return sb.toString();
	}

}
