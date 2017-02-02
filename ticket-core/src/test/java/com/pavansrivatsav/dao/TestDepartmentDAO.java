package com.pavansrivatsav.dao;

import java.util.List;

import com.pavansrivatsav.modal.Department;

public class TestDepartmentDAO {
	public static void main(String args[]) {

		Department dept = new Department();
		DepartmentDAO deptdao = new DepartmentDAO();
		/* insert */

		// dept.setId(1);
		// dept.setName("IT");
		// dept.setStatus(true);
		// System.out.println(deptdao.insert(dept));
		//
		/* update */

		// dept.setStatus(false);
		// dept.setId(1);
		// System.out.println(deptdao.update(dept));

		/* Delete */

		// dept.setId(1);
		// System.out.println(deptdao.delete(dept));

		/* Select */

		List<Department> deptlist = deptdao.find();
		for (Department i : deptlist) {

			System.out.println(i);
		}
	}
}
