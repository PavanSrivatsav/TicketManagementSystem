package com.pavansrivatsav.dao;

import java.util.List;

import com.pavansrivatsav.modal.Department;
import com.pavansrivatsav.modal.EmployeeDetail;

public class TestEmployeeDetailDAO {
	public static void main(String[] args) {

		EmployeeDetail empDetail = new EmployeeDetail();
		EmployeeDetailDAO empDetailDAO = new EmployeeDetailDAO();

		/* insert */
		empDetail.setId(3);
		empDetail.setName("test");
		Department dept = new Department();
		dept.setId(1);
		empDetail.setDept(dept);
		empDetail.setEmailId("tesstt@gmail.com");
		empDetail.setPassword("testPassword");
		empDetail.setStatus(true);
		System.out.println("Inserted : " + empDetailDAO.insert(empDetail));

		/* update */

		// empDetail.setPassword("test");
		// empDetail.setEmailId("");
		// System.out.println("Updated : " + empDetailDAO.update(empDetail));
		//
		// /* Delete */
		// empDetail.setId(3);
		// System.out.println("Deleted : " + empDetailDAO.delete(empDetail));
		//
		// /* Select */
		//
		// List<EmployeeDetail> emplist = empDetailDAO.select();
		// for (EmployeeDetail i : emplist) {
		//
		// System.out.println(i);
		// }
	}
}
