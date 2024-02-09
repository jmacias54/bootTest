package com.xideral.bootTest.repository;

import com.xideral.bootTest.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	Optional<Employee> findByEmployeeNameAndEmployeeFirstNameAndEmployeeLastName(
		String name,
		String firstName,
		String lastName
	);

}
