package com.go2it.edu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.go2it.edu.service.EmployeeService;

/**
 * @author Alex Ryzhkov
 */
@CrossOrigin(origins = { "http://localhost:3000" })
@RestController
@RequestMapping(value = "/api")
public class EmployeeController {
	@Autowired private EmployeeService employeeService;

	@RequestMapping(value = "/employees/{id}", method = RequestMethod.GET)
	public String getUserById(@PathVariable(name = "id") String employeeId) {
		return "Something";
	}

	@RequestMapping(value = "/employees", method = RequestMethod.GET)
	public String getUsers() {
		return employeeService.getUsers();
	}

	@RequestMapping(value = "/employee", method = RequestMethod.POST)
	public String createNewEmployee(@RequestBody String body) {
		return "";
	}

	@RequestMapping(value = "/employee/{id}", method = RequestMethod.PUT)
	public String updateEmployee(@PathVariable(name = "id") String employeeId) {

		return "";
	}

	@RequestMapping(value = "/delete/{id}")
	public String deleteEmployee(@PathVariable(name = "id") String employeeId) {
		return "";
	}

}
