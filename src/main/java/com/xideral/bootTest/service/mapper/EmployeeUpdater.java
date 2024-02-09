package com.xideral.bootTest.service.mapper;

import com.xideral.bootTest.controller.employee.request.EmployeeUpdateRequest;
import com.xideral.bootTest.entities.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeUpdater {

	public Employee updater(Integer id, Employee employee, EmployeeUpdateRequest request) {

		return employee
			.setEmployeeId(id)
			.setEmployeeName(request.getFirstName())
			.setEmployeeLastName(request.getLastName())
			.setEmployeeBirthDate(request.getBirthDate());
	}
}
