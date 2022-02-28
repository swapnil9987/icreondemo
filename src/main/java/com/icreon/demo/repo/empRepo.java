package com.icreon.demo.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.icreon.demo.model.Employee;

public interface empRepo extends JpaRepository<Employee, Integer>{

	List<Employee> findByName(String name);
	List<Employee> findBySalary(Integer salary);
}
