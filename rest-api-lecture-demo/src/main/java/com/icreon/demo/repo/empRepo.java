package com.icreon.demo.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.icreon.demo.model.Employee;

public interface empRepo extends CrudRepository<Employee, Integer>{

	List<Employee> findByName(String name);
	List<Employee> findBySalary(Integer salary);
}
