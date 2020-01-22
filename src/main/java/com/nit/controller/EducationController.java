package com.nit.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nit.entity.EducationalDetailsEntity;
import com.nit.entity.PersonEntity;
import com.nit.model.EducationModel;
import com.nit.service.PassportManagementService;

@Controller
public class EducationController {

	@Autowired
	private PassportManagementService service;

	/**
	 * This method is used for lunching education page
	 * 
	 * @param model
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "/education", method = RequestMethod.GET)
	public String lunchedducationPage(Model model, HttpServletRequest req) {

		String parameter = req.getParameter("pid");
		EducationModel emodel = new EducationModel();
		if (!parameter.isEmpty() && parameter != "null") {
			int pid = Integer.parseInt(parameter);
			emodel.setPersonId(pid);
		}

		List<String> degreeList = service.allDegres();
		model.addAttribute("degreeList", degreeList);

		List<String> alluniversity = service.alluniversity();
		model.addAttribute("alluniversity", alluniversity);

		List<Integer> allYear = service.allYear();
		model.addAttribute("allYear", allYear);

		model.addAttribute("educationalDetails", emodel);
		return "education";
	}

	/**
	 * This method is used for insert education data in data base and redirect to
	 * ApplicationReviewController
	 * 
	 * @param emodel
	 * @param attribute
	 * @return
	 */
	@RequestMapping(value = "/handleEduNextBtn")
	public String handlesubmitbutton(@ModelAttribute("educationalDetails") EducationModel emodel,
			RedirectAttributes attribute) {
		emodel = service.insertValue(emodel);

		Optional<PersonEntity> getdataByID = service.getdataByID(emodel.getPersonId());
		
		PersonEntity personEntity = getdataByID.get();
		
		attribute.addFlashAttribute("persondetails", personEntity);
		
		Optional<EducationalDetailsEntity> geteducationdataByID = service.geteducationdataByID(emodel.getEduId());
		
		EducationalDetailsEntity educationalDetailsEntity = geteducationdataByID.get();
		
		attribute.addFlashAttribute("educationdetails", educationalDetailsEntity);
		
		return "redirect:/showReviewForm?personId=" + emodel.getPersonId();
	}

}
