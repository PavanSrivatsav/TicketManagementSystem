package com.pavansrivatsav.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pavansrivatsav.exception.ServiceException;
import com.pavansrivatsav.service.EmployeeModuleService;

@Controller
@RequestMapping("/employeeLogin")
public class EmployeeLoginController {
	private EmployeeModuleService ems = new EmployeeModuleService();

	@GetMapping
	public String empLogin(@RequestParam("empEmail") String emailId, @RequestParam("empPassword") String password,
			ModelMap modelMap, HttpSession httpSession) {

		System.out.println("login->empLogin");
		try {
			ems.logIn(emailId, password);
			httpSession.setAttribute("EMP_LOGGED_IN", emailId);
			// EmployeeDetail emp = (EmployeeDetail)
			// httpSession.getAttribute("EMP_LOGGED_IN");
		} catch (ServiceException e) {
			modelMap.addAttribute("EMPLOYEE_LOGIN", e.getMessage());
			return "/";
		}
		return "redirect:/employeeModule";
	}
}
