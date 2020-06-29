package com.Controller;

import java.util.List;
import java.util.Set;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Entity.AccountEntity;
import com.Entity.EmployeeEntity;
import com.Repository.AcccountRepository;
import com.Repository.EmployeeRepository;

@RestController
@RequestMapping("/onetomany")
public class EmployeeController {

	@Autowired
	EmployeeRepository employeeRepository;
	@Autowired
	AcccountRepository acccountRepository;

	@PostMapping("/add")
	public EmployeeEntity add(@RequestBody EmployeeEntity employeeEntity) {
		employeeEntity = employeeRepository.save(employeeEntity);

		for (AccountEntity accountEntity : employeeEntity.getAccountEntity()) {
			accountEntity.setEmployeeEntity(employeeEntity);
		}
		return employeeRepository.save(employeeEntity);
	}

	@GetMapping("/getAll")
	public List<EmployeeEntity> getAll() {
		return employeeRepository.findAll();
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity delete(@PathVariable Integer id) {
		employeeRepository.deleteById(id);
		return new ResponseEntity("deleted", HttpStatus.ACCEPTED);
	}

	@PatchMapping("/getById/{id}")
	public EmployeeEntity getById(@PathVariable Integer id) {
		return employeeRepository.findById(id).orElse(null);
	}

	@PostMapping("/update/{id}")
	public EmployeeEntity update(@PathVariable Integer id, @RequestBody EmployeeEntity employeeEntity) {
		return employeeRepository.save(employeeEntity);
	}
}
