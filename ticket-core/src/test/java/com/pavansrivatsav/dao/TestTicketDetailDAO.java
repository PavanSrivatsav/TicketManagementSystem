package com.pavansrivatsav.dao;

import java.time.LocalDateTime;
import java.util.List;

import com.pavansrivatsav.modal.Department;
import com.pavansrivatsav.modal.EmployeeDetail;
import com.pavansrivatsav.modal.TicketDetail;
import com.pavansrivatsav.modal.UserDetail;

public class TestTicketDetailDAO {
	public static void main(String args[]) {

		TicketDetail ticketDetail = new TicketDetail();
		TicketDetailDAO ticketDetailDao = new TicketDetailDAO();
		//
		/* Insert */

		// ticketDetail.setId(6);
		//
		// UserDetail userDetail = new UserDetail();
		// userDetail.setId(1);
		// ticketDetail.setUser(userDetail);
		//
		// Department department = new Department();
		// department.setId(1);
		// ticketDetail.setTicketDept(department);
		//
		// ticketDetail.setSubject("having prob");
		// ticketDetail.setDescription("dhbdbjdnckd");
		//
		// EmployeeDetail employeeDetail = new EmployeeDetail();
		// employeeDetail.setId(1);
		// ticketDetail.setEmp(employeeDetail);
		//
		// ticketDetail.setCreated(LocalDateTime.now());
		// ticketDetail.setStatus("open");
		//
		// ticketDetail.setModified(LocalDateTime.parse("2017-02-02T08:10:00"));
		//
		// ticketDetailDao.insert(ticketDetail);

		/* update */
		//
		// ticketDetail.setStatus("closed");
		// ticketDetail.setId(1);
		// System.out.println(ticketDetailDao.update(ticketDetail));

		/* Delete */

		// ticketDetail.setId(1);
		// System.out.println(ticketDetailDao.delete(ticketDetail));

		TicketDetailDAO ticketDao = new TicketDetailDAO();
		List<TicketDetail> ticketlist = ticketDao.find();
		for (TicketDetail i : ticketlist) {

			System.out.println(i);
		}

	}
}
