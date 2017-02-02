package com.pavansrivatsav.modal;

import lombok.Data;

@Data
public class UserDetail {

	private Integer id;
	private String name;
	private String emailId;
	private String password;
	private Boolean status;
}
