package com.pavansrivatsav.dao;

import java.util.List;

import com.pavansrivatsav.exception.PersistenceException;
import com.pavansrivatsav.modal.Department;
import com.pavansrivatsav.modal.EmployeeDetail;
import com.pavansrivatsav.modal.Role;

public class TestEmployeeDetailDAO {
	public static void main(String[] args) throws PersistenceException {

		EmployeeDetail empDetail = new EmployeeDetail();
		EmployeeDetailDAO empDetailDAO = new EmployeeDetailDAO();

		/* insert */
		// empDetail.setId(3);
		// empDetail.setName("test");
		// Department dept = new Department();
		// dept.setId(1);
		// empDetail.setDept(dept);
		// Role role = new Role();
		// role.setId(1);
		// empDetail.setRoleId(role);
		// empDetail.setEmailId("tesstt@gmail.com");
		// empDetail.setPassword("testPassword");
		// empDetail.setStatus(true);
		// System.out.println("Inserted : " + empDetailDAO.insert(empDetail));

		/* update */

		// empDetail.setPassword("test");
		// empDetail.setEmailId("");
		// System.out.println("Updated : " + empDetailDAO.update(empDetail));
		//
		/* Delete */
		// empDetail.setId(3);
		// System.out.println("Deleted : " + empDetailDAO.delete(empDetail));
		//
		// /* Select */
		//
		// List<EmployeeDetail> emplist = empDetailDAO.find();
		// for (EmployeeDetail i : emplist) {
		//
		// System.out.println(i);
		// }
		// empDetailDAO.getEmailId(1);
		empDetailDAO.getPassword("PAVAN@GMAIL.COM");
	}
}
