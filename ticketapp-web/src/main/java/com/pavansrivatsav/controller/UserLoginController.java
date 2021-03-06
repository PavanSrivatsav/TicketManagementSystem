package com.pavansrivatsav.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pavansrivatsav.exception.ServiceException;
import com.pavansrivatsav.service.UserModuleService;

@Controller
@RequestMapping("/userLogin")
public class UserLoginController {
	private UserModuleService ums = new UserModuleService();

	@GetMapping
	public String userLogin(@RequestParam("userEmail") String emailId, @RequestParam("userPassword") String password,
			ModelMap modelMap, HttpSession session) {
	
		try {
			session.setAttribute("USER_LOGGED_IN", emailId);
			ums.logIn(emailId, password);
		} catch (ServiceException e) {
			modelMap.addAttribute("USER_LOGIN", e.getMessage());
			return "/";
		}
		return "redirect:/userModule";
	}

}
