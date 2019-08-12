package com.spr.dao;

import java.util.ArrayList;
import com.spr.model.Employee;

public class EmployeeRepo {
	
	ArrayList<Employee> empList=new ArrayList<Employee>();
	Employee emp1=new Employee();
	public ArrayList<Employee> getAllEmployee(){
		return empList;
	}
}
