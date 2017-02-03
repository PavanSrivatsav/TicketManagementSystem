package com.pavansrivatsav.modal;

import lombok.Data;

@Data
public class EmployeeDetail {

	private Integer id;
	private Department dept;
	private Role roleId;
	private String name;
	private String emailId;
	private String password;
	private Boolean status;

}
