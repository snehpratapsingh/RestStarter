package com.spr.resource;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spr.model.Employee;


@RestController
@RequestMapping(path = "/emp/")
public class EmployeeResource {
	public ArrayList<Employee>getEmpolyeeList() {
		
		return new ArrayList<Employee>();
	}

}
