package com.pavansrivatsav.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pavansrivatsav.dao.LoginDAO;
import com.pavansrivatsav.exception.PersistenceException;

@Controller
@RequestMapping("/adminLogin")
public class AdminLoginController {
	private LoginDAO login = new LoginDAO();

	@GetMapping
	public String adminLogin(@RequestParam("adminEmail") String emailId, @RequestParam("adminPassword") String password,
			ModelMap modelMap, HttpSession httpSession) {

	
		try {
			login.adminLogIn(emailId, password);
			httpSession.setAttribute("ADMIN_LOGGED_IN", emailId);

		} catch (PersistenceException e) {
			modelMap.addAttribute("ADMIN_LOGIN", e.getMessage());
			return "/admin";
		}
		return "redirect:/adminModule";

	}
}
