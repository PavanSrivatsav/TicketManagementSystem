package com.pavansrivatsav.modal;

import lombok.Data;

@Data
public class IssueHistory {

	private Integer id;
	private TicketDetail ticketId;
	private String solution;
}
