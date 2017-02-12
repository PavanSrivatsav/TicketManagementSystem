package com.pavansrivatsav.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pavansrivatsav.exception.ServiceException;
import com.pavansrivatsav.modal.UserDetail;
import com.pavansrivatsav.service.UserDetailService;

@Controller
@RequestMapping("/userRegistration")
public class UserRegistrationController {
	private UserDetail user = new UserDetail();
	private UserDetailService userService = new UserDetailService();

	@GetMapping
	public String userRegister() {

		return "userReg.jsp";
	}

	@GetMapping("/register")
	public String register(@RequestParam("username") String name, @RequestParam("userEmail") String emailId,
			@RequestParam("userPassword") String password, ModelMap modelMap) {

		try {
			user.setName(name);
			user.setEmailId(emailId);
			user.setPassword(password);
			userService.insert(user);
		}

		catch (ServiceException e) {
			modelMap.addAttribute("USER_REGISTRATION", e.getMessage());
			return "/userRegistration";
		}

		return "redirect:/";
	}
}
