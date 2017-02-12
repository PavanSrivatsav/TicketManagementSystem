package com.pavansrivatsav.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pavansrivatsav.exception.ServiceException;
import com.pavansrivatsav.modal.Department;
import com.pavansrivatsav.service.DepartmentService;

@Controller
@RequestMapping("/department")
public class DepartmentController {
	private Department dept = new Department();
	private DepartmentService ds = new DepartmentService();

	@GetMapping
	public String index(ModelMap modelmap, HttpSession session) {
	
		List<Department> deptList;
		deptList = ds.findAll();
		modelmap.addAttribute("DEPARTMENT_LIST", deptList);

		return "department.jsp";
	}

	@GetMapping("/save")
	public String save(@RequestParam("deptname") String name, ModelMap modelmap) {
		
		dept.setName(name);
		dept.setStatus(true);
		try {
			ds.insert(dept);
		} catch (ServiceException e) {
			modelmap.addAttribute("INSERT_ERROR", e.getMessage());
			return "../department";
		}
		return "redirect:../department";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam("id") Integer id, ModelMap modelmap) throws ServiceException {
		
		dept.setId(id);
		try {
			ds.delete(dept);
		} catch (ServiceException er) {
			modelmap.addAttribute("DELETE_ERROR", er.getMessage());
			return "../department";
		}
		return "redirect:../department";
	}

	@GetMapping("/update")
	public String update(@RequestParam("id") Integer id, @RequestParam("upDeptname") String name,
			@RequestParam("status") Boolean status) {
		
		dept.setId(id);
		dept.setName(name);
		dept.setStatus(status);
		try {
			ds.update(dept);
		} catch (ServiceException e) {
			return "../department";
		}
		return "redirect:../department";
	}

}