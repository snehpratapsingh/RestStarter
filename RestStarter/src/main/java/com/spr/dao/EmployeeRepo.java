package com.spr.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.spr.model.Employee;
@Component
@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

}
