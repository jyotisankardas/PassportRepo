package com.nit.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nit.model.PassportDetailsModel;
import com.nit.service.PassportManagementService;

@Controller
public class ApplicationReviewController {

	@Autowired
	private PassportManagementService service;

	/**
	 * This method is used for show all final records in applicationReviewForm page
	 * 
	 * @param model
	 * @param request
	 * @return
	 */

	@RequestMapping(value = "/showReviewForm")
	public String showApplicationReviewForm(Model model, HttpServletRequest request) {
		PassportDetailsModel pmodel = new PassportDetailsModel();
		String personId = request.getParameter("personId");
		if (personId != null && !personId.isEmpty()) {
			int pid = Integer.parseInt(personId);
			pmodel.setPersonId(pid);
		}
		model.addAttribute("passportAppDtls", pmodel);
		return "applicationReviewForm";
	}

	/**
	 * This method is used for open dasbord and get Passport number
	 * 
	 * @param pmodel
	 * @param attributes
	 * @return
	 */
	@RequestMapping(value = "/handleConfirmBtn", method = RequestMethod.POST)
	public String handleConfirmBtn(@ModelAttribute("passportAppDtls") PassportDetailsModel pmodel,
			RedirectAttributes attributes) {
		pmodel = service.savePassportDetailsWithPassportNumber(pmodel);
		if (pmodel != null) {
			attributes.addFlashAttribute("successMsg", "Your Passport Number Generated Successfully");
			attributes.addFlashAttribute("passportNumber", pmodel.getPassportNumber());
		} else {
			attributes.addFlashAttribute("errorMsg", "Your Passport Number Generation Failed");
		}

		return "redirect:/passportDashBoard";
	}

	@RequestMapping(value = "/passportDashBoard")
	public String enterIntoPassportDashBoard() {
		return "passportDashBoard";
	}

}
