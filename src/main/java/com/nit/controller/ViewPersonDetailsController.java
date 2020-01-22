package com.nit.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nit.entity.PersonEntity;
import com.nit.model.PersonModel;
import com.nit.service.PassportManagementService;

@Controller
public class ViewPersonDetailsController {

	@Autowired
	private PassportManagementService service;

	/**
	 * This method is used for lunching form page and logic for get data By ID
	 * 
	 * @param model
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "/")
	public String lunchRegisterformPage(Model model, HttpServletRequest req) {
		PersonModel comand = new PersonModel();
		String pid = req.getParameter("personId");
		if (pid != null && !pid.isEmpty()) {
			Integer persionId = Integer.parseInt(pid);
			Optional<PersonEntity> getdataByID = service.getdataByID(persionId);
			if (getdataByID.isPresent()) {
				PersonEntity personEntity = getdataByID.get();
				BeanUtils.copyProperties(personEntity, comand);
			}
		}
		model.addAttribute("beans", comand);
		return "person";

	}

	/**
	 * This method is used for stored data in data base and rediect to
	 * EducationController
	 * 
	 * @param pmodel
	 * @return
	 */
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String handleSubmitButton(@ModelAttribute("beans") PersonModel pmodel) {
		System.out.println(pmodel);
		int pid = service.insertRecords(pmodel);
		return "redirect:/education?pid=" + pid;

	}

}
