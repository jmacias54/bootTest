package com.xideral.bootTest.service;

import com.xideral.bootTest.controller.employee.request.EmployeeCreateRequest;
import com.xideral.bootTest.controller.employee.request.EmployeeRegisterLikeUserRequest;
import com.xideral.bootTest.controller.employee.request.EmployeeUpdateAndSetAccessRequest;
import com.xideral.bootTest.controller.employee.request.EmployeeUpdateRequest;
import com.xideral.bootTest.controller.employee.response.EmployeeCreateResponse;
import com.xideral.bootTest.controller.employee.response.EmployeeUpdateAndSetAccessResponse;
import com.xideral.bootTest.entities.Employee;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface EmployeeService {

	Integer create(EmployeeCreateRequest request);

	EmployeeUpdateAndSetAccessResponse updateAndSetAccess(
		Integer employeeId,
		EmployeeUpdateAndSetAccessRequest request
	);

	EmployeeUpdateAndSetAccessResponse addLikeUser(
		EmployeeRegisterLikeUserRequest request
	);

	EmployeeCreateResponse updateAndRemoveAccess(
		Integer employeeId,
		EmployeeUpdateRequest request
	);

	List<Employee> getAllEmployees();
}
