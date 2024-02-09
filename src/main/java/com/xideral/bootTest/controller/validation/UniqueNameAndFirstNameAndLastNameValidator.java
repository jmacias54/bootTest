package com.xideral.bootTest.controller.validation;

import com.xideral.bootTest.controller.employee.request.EmployeeCreateRequest;
import com.xideral.bootTest.entities.Employee;
import com.xideral.bootTest.repository.EmployeeRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UniqueNameAndFirstNameAndLastNameValidator implements ConstraintValidator<UniqueNameAndFirstNameAndLastName, EmployeeCreateRequest> {

	private final EmployeeRepository employeeRepository;

	@Override
	public void initialize(UniqueNameAndFirstNameAndLastName constraintAnnotation) {
	}


	@Override
	public boolean isValid(EmployeeCreateRequest request, ConstraintValidatorContext constraintValidatorContext) {

		Optional<Employee> employeeOptional = this.employeeRepository.findByEmployeeNameAndEmployeeFirstNameAndEmployeeLastName(
			request.getName(),
			request.getFirstName(),
			request.getLastName()
		);

		return employeeOptional.isEmpty();
	}
}
