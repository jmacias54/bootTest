package com.xideral.bootTest.service.validation;


import com.xideral.bootTest.entities.Employee;
import com.xideral.bootTest.exception.BadRequestException;
import com.xideral.bootTest.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
@RequiredArgsConstructor
public class EmployeeIsUnique {

	private final EmployeeRepository employeeRepository;

	public void isUnique(String name, String firstName, String lastName) {

		Optional<Employee> employeeOptional = this.employeeRepository.findByEmployeeNameAndEmployeeFirstNameAndEmployeeLastName(
			name,
			firstName,
			lastName
		);

		if(employeeOptional.isPresent())
			throw new BadRequestException("employee.nonUnique");

	}


}
