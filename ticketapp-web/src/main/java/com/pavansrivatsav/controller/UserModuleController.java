package com.pavansrivatsav.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pavansrivatsav.exception.ServiceException;
import com.pavansrivatsav.modal.Department;
import com.pavansrivatsav.modal.TicketDetail;
import com.pavansrivatsav.modal.UserDetail;
import com.pavansrivatsav.service.TicketDetailService;
import com.pavansrivatsav.service.UserModuleService;

@Controller
@RequestMapping("/userModule")
public class UserModuleController {
	private UserModuleService ums = new UserModuleService();
	private TicketDetail ticketDetail = new TicketDetail();
	private Department dept = new Department();
	private UserDetail user = new UserDetail();
	private TicketDetailService ticketDetailService = new TicketDetailService();

	@GetMapping
	public String index(ModelMap modelmap) {
		System.out.println("userModule->index");
		List<TicketDetail> userList;
		userList = ticketDetailService.findById(8);
		modelmap.addAttribute("USER_TICKET_LIST", userList);
		return "TicketGeneration.jsp";
	}

	@GetMapping("/ticketInsert")
	public String ticketRegistration(@RequestParam("subject") String subject,
			@RequestParam("description") String description, @RequestParam("dept") Integer department,
			@RequestParam("priority") String priority, ModelMap modelMap) {
		System.out.println("usermodule->ticketCreate");
		try {
			user.setId(8);
			ticketDetail.setUser(user);
			ticketDetail.setSubject(subject);
			ticketDetail.setDescription(description);
			ticketDetail.setPriority(priority);
			dept.setId(department);
			ticketDetail.setTicketDept(dept);
			ums.ticketGeneration(ticketDetail, "pavansrivatsav96@gmail.com", "askjhashdkj");
		} catch (ServiceException e) {
			modelMap.addAttribute("TICKET_ERROR", e.getMessage());
			return "/userModule";
		}
		return "redirect:../department";
	}

	@GetMapping("/ticketEdit")
	public String ticket(@RequestParam("id") Integer id, @RequestParam("editsubject") String subject,
			@RequestParam("editdescription") String description, @RequestParam("editstatus") String status,
			ModelMap modelMap) {
		System.out.println("usermodule->ticketEdit");
		ticketDetail.setId(id);
		ticketDetail.setSubject(subject);
		ticketDetail.setDescription(description);
		ticketDetail.setStatus(status);
		System.out.println("id->" + id);
		try {
			ums.updateTicket(ticketDetail);
		} catch (ServiceException e) {
			modelMap.addAttribute("TICKET_UPDATE_ERROR", e.getMessage());
			return "../userModule";
		}
		return "redirect:../userModule";
	}

	@GetMapping("/ticketClose")
	public String ticket(@RequestParam("id") Integer id, ModelMap modelMap) {
		System.out.println("usermodule->ticketClose");
		try {
			ums.closeTicket(id);
		} catch (ServiceException e) {
			modelMap.addAttribute("TICKET_CLOSE_ERROR", e.getMessage());
			return "../userModule";
		}
		return "redirect:../userModule";
	}

}
