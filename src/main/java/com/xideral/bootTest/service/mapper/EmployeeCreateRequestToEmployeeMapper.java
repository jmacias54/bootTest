package com.xideral.bootTest.service.mapper;

import com.xideral.bootTest.contract.Mapper;
import com.xideral.bootTest.controller.employee.request.EmployeeCreateRequest;
import com.xideral.bootTest.entities.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeCreateRequestToEmployeeMapper implements Mapper<EmployeeCreateRequest, Employee> {
	@Override
	public Employee map(EmployeeCreateRequest input) {
		return new Employee()
			.setEmployeeName(input.getName())
			.setEmployeeFirstName(input.getFirstName())
			.setEmployeeLastName(input.getLastName())
			.setEmployeeBirthDate(input.getBirthDate());
	}
}
