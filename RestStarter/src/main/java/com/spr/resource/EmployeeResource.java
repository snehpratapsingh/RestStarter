package com.spr.resource;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
@RequestMapping(path = "/emp/" )
public class EmployeeResource {

	@Autowired
	EmployeeRepo employeeRepo;
	
	Logger logger = LoggerFactory.getLogger(EmployeeResource.class);
	//Logger logger1;

	@GetMapping(path = "/")
	public ResponseEntity<List<Employee>> getEmpolyeeList() {
		logger.info("getEmpolyeeList() Called.");
		List<Employee> empList;
		empList = employeeRepo.findAll();
		logger.debug("All employees returned.");
		return new ResponseEntity<>(empList, HttpStatus.OK);
	}

	@PostMapping(path = "/add")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee emp) {
		logger.info("addEmployee() Called.");
		employeeRepo.save(emp);
		logger.debug("Employee Added:"+emp.getEmpName());
		return new ResponseEntity<>(emp, HttpStatus.OK);
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<Employee> getEmpById(@PathVariable("id") int id) {
		logger.info("getEmpById() Called.");
		Employee emp = employeeRepo.findById(id).orElse(null);
		if (emp == null) {
			logger.debug("Employee Not Found");
			return new ResponseEntity<>(emp, HttpStatus.NO_CONTENT);
		}
		logger.debug("Employee Found:"+emp.getEmpName());
		return new ResponseEntity<>(emp, HttpStatus.OK);
	}
}
