package com.icreon.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.icreon.demo.model.Employee;
import com.icreon.demo.repo.empRepo;

@RestController
public class myController {
	
	@Autowired
	empRepo er;
//	
//	@GetMapping("/getall")
//	public List<Employee>getall(){
//		Iterable<Employee>itr=er.findAll();
//		for(Employee e:itr) {
//			System.out.println(e);
//		}
//		return null;
//	}
	
	@GetMapping("/getall")
	public List<Employee>getAll(){
		List<Employee>emp=new ArrayList<>();
		//er.findAll().forEach(e->emp.add(e));
		er.findAll().forEach(e->emp.add(e));
		return emp;
	}
	
	@PostMapping("/addemp")
	public Employee insert(@RequestBody Employee e) {
		return er.save(e);
	}
	
	
	@GetMapping("/getone/{id}")
	public Employee getOne(@PathVariable Integer id) {
		//List<Employee>list=new ArrayList<Employee>();
		Optional<Employee>emp=er.findById(id);
		return emp.get();
		
	}
	
	
	@GetMapping("/getname/{name}")
	public List<Employee> getName(@PathVariable String name) {
		//List<Employee>list=new ArrayList<Employee>();
		//Optional<Employee>emp=er.findById(id);
		return er.findByName(name);
		
	}
	
	
	@GetMapping("/getSal/{salary}")
	public List<Employee> getSal(@PathVariable Integer salary) {
		//List<Employee>list=new ArrayList<Employee>();
		//Optional<Employee>emp=er.findById(id);
		return er.findBySalary(salary);
		
	}
	
	
	
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable Integer id) {
		
		er.deleteById(id);
	}
     
	@PutMapping("/update")
 public Employee update(@RequestBody Employee e) {
	 er.save(e);
	 return e;
	 
 }
}
