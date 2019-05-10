package com.go2it.edu.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.go2it.edu.service.EmployeeService;

/**
 * @author Alex Ryzhkov
 */
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(value = "/api")
public class EmployeeController {
	@Autowired private EmployeeService employeeService;

	@RequestMapping(value = "/employees/{id}", method = RequestMethod.GET)
	public ResponseEntity<JSONObject> getUserById(@PathVariable(name = "id") String employeeId) {
		return new ResponseEntity<>(new JSONObject("\"status\":\"succesful\""), HttpStatus.OK);
	}

	@RequestMapping(value = "/employees", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<String> getUsers() {
		return ResponseEntity.ok().body(employeeService.getUsers());
	}

	@RequestMapping(value = "/employee", method = RequestMethod.POST)
	public ResponseEntity<JSONObject> createNewEmployee(@RequestBody String body) {
		return new ResponseEntity<>(new JSONObject("\"status\":\"succesful\""), HttpStatus.OK);
	}

	@RequestMapping(value = "/employee/{id}", method = RequestMethod.PUT)
	public ResponseEntity<JSONObject> updateEmployee(@PathVariable(name = "id") String employeeId) {
		return new ResponseEntity<>(new JSONObject("\"status\":\"succesful\""), HttpStatus.OK);
	}

	@RequestMapping(value = "/delete/{id}")
	public ResponseEntity<JSONObject> deleteEmployee(@PathVariable(name = "id") String employeeId) {
		return new ResponseEntity<>(new JSONObject("\"status\":\"succesful\""), HttpStatus.OK);
	}

}
