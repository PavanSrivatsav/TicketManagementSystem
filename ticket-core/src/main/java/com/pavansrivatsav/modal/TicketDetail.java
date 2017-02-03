package com.pavansrivatsav.modal;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class TicketDetail {

	private Integer id;
	private UserDetail user;
	private Department ticketDept;
	private String subject;
	private String description;
	private String priority;
	private EmployeeDetail emp;
	private LocalDateTime created;
	private String status;
	private LocalDateTime modified;

}
