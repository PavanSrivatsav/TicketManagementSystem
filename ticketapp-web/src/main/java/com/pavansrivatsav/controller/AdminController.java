package com.pavansrivatsav.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pavansrivatsav.dao.EmployeeModule;
import com.pavansrivatsav.dao.TicketDetailDAO;
import com.pavansrivatsav.exception.PersistenceException;
import com.pavansrivatsav.exception.ServiceException;
import com.pavansrivatsav.modal.TicketDetail;

@Controller
@RequestMapping("/adminModule")
public class AdminController {
	private TicketDetailDAO ticketDetailDao = new TicketDetailDAO();
	private TicketDetail ticketDetail = new TicketDetail();
	private EmployeeModule empmod = new EmployeeModule();

	@GetMapping
	public String empTicketDisplay(ModelMap modelmap) {

		List<TicketDetail> ticketList;
		ticketList = ticketDetailDao.find();
		modelmap.addAttribute("ADMIN_TICKET_LIST", ticketList);
		return "adminpage.jsp";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam("id") Integer id, ModelMap modelmap) throws ServiceException {

		try {
			ticketDetail.setId(id);

			ticketDetailDao.delete(ticketDetail);

		} catch (PersistenceException er) {
			modelmap.addAttribute("DELETE_ERROR", er.getMessage());
			return "../adminModule";
		}
		return "redirect:../adminModule";
	}

	@GetMapping("/assignTicket")
	public String assignTicket(@RequestParam("ticketId") Integer id, @RequestParam("employeeId") Integer empId,
			ModelMap modelmap, HttpSession session) throws ServiceException {
		String email = (String) (session.getAttribute("ADMIN_LOGGED_IN"));
		try {

			empmod.assignTicketToEmployee(email, empId, id);
		} catch (PersistenceException er) {
			modelmap.addAttribute("DELETE_ERROR", er.getMessage());
			return "../adminModule";
		}
		return "redirect:../adminModule";
	}
}
