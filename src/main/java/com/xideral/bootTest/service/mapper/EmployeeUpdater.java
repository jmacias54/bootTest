package com.xideral.bootTest.service.mapper;

import com.xideral.bootTest.controller.employee.request.EmployeeUpdateRequest;
import com.xideral.bootTest.entities.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeUpdater {

	public Employee updater(Integer id, Employee employee, EmployeeUpdateRequest request) {

		request.getName().ifPresent(employee::setEmployeeName);
		request.getFirstName().ifPresent(employee::setEmployeeFirstName);
		request.getLastName().ifPresent(employee::setEmployeeLastName);
		request.getBirthDate().ifPresent(employee::setEmployeeBirthDate);

		return employee;
	}


}
