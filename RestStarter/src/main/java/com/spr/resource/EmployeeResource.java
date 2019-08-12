package com.spr.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spr.dao.EmployeeRepo;
import com.spr.model.Employee;

@RestController
@RequestMapping(path = "/emp/")
public class EmployeeResource {

	@Autowired
	EmployeeRepo employeeRepo;

	@GetMapping(path = "/")
	public ResponseEntity<List<Employee>> getEmpolyeeList() {
		List<Employee> empList;
		empList = employeeRepo.findAll();
		return new ResponseEntity<>(empList, HttpStatus.OK);
	}

	@PostMapping(path = "/add")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee emp) {

		employeeRepo.save(emp);
		return new ResponseEntity<>(emp, HttpStatus.OK);
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<Employee> getEmpById(@PathVariable("id") int id) {
		
		Employee emp = employeeRepo.findById(id).orElse(null);
		if (emp == null) {
			return new ResponseEntity<>(emp, HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(emp, HttpStatus.OK);
	}
}
