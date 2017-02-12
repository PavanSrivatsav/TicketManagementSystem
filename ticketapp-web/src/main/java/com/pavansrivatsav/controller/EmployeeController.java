package com.pavansrivatsav.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pavansrivatsav.dao.EmployeeDetailDAO;
import com.pavansrivatsav.dao.EmployeeModule;
import com.pavansrivatsav.exception.PersistenceException;
import com.pavansrivatsav.exception.ServiceException;
import com.pavansrivatsav.modal.IssueHistory;
import com.pavansrivatsav.modal.TicketDetail;
import com.pavansrivatsav.service.EmployeeModuleService;

@Controller
@RequestMapping("/employeeModule")
public class EmployeeController {
	private EmployeeModule em = new EmployeeModule();
	private EmployeeModuleService ems = new EmployeeModuleService();
	private EmployeeDetailDAO empDao = new EmployeeDetailDAO();
	private IssueHistory issueHistory = new IssueHistory();
	private TicketDetail ticketId = new TicketDetail();

	@GetMapping
	public String empTicketDisplay(ModelMap modelmap, HttpSession session) throws PersistenceException {

		List<TicketDetail> empList;
		String email = (String) (session.getAttribute("EMP_LOGGED_IN"));
		Integer empId = empDao.getEmpId(email);
		if (empId == null || empId < 0) {
			return "redirect:/";
		} else {
			try {

				empList = em.displayTicket(empId);
				modelmap.addAttribute("EMP_TICKET_LIST", empList);

			} catch (PersistenceException e) {
				return "employeeModule.jsp";
			}

			return "employeeModule.jsp";
		}
	}

	@GetMapping("/replyticket")
	public String empTicketReply(@RequestParam("id") Integer id, @RequestParam("solution") String solution,
			ModelMap modelmap, HttpSession session) {

		try {
			ticketId.setId(id);
			issueHistory.setTicketId(ticketId);
			issueHistory.setSolution(solution);

			ems.replyToTicket(issueHistory);

		} catch (ServiceException e) {
			modelmap.addAttribute("EMP_REPLY_TICKET", e.getMessage());
			return "../employeeModule";
		}
		return "redirect:../employeeModule";
	}

	@GetMapping("/resolve")
	public String empTicketResolve(@RequestParam("id") Integer id, ModelMap modelmap) {

		em.employeeResolve(id);
		return "redirect:../employeeModule";
	}

	@GetMapping("/reassignticket")
	public String empTicketReassign(@RequestParam("TicketId") Integer ticketId,
			@RequestParam("empId") Integer employeeId, ModelMap modelmap) {

		try {
			em.reAssignTicketToEmployee(employeeId, ticketId);
		} catch (PersistenceException e) {
			return "redirect:../employeeModule";
		}
		return "redirect:../employeeModule";
	}
}
