package com.pavansrivatsav.dao;

import com.pavansrivatsav.modal.Department;
import com.pavansrivatsav.modal.TicketDetail;
import com.pavansrivatsav.modal.UserDetail;

public class TestGenerationDAO {

	public static void main(String[] args) {

		TicketGenerationDAO ticGen = new TicketGenerationDAO();
		TicketDetail ticketDetail = new TicketDetail();
		Department dept = new Department();
		UserDetail user = new UserDetail();
		user.setId(1);
		dept.setId(1);
		ticketDetail.setTicketDept(dept);
		ticketDetail.setDescription("Laptop");
		ticketDetail.setUser(user);
		ticketDetail.setSubject("Wifi- Problem");
		System.out.println(ticGen.ticketGenerate(ticketDetail));
	}
}
