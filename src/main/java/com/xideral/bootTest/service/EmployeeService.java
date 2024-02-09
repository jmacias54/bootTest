package com.xideral.bootTest.service;

import com.xideral.bootTest.controller.employee.request.EmployeeCreateRequest;
import com.xideral.bootTest.controller.employee.request.EmployeeUpdateAndSetAccessRequest;
import com.xideral.bootTest.controller.employee.response.EmployeeUpdateAndSetAccessResponse;

public interface EmployeeService {

	Integer create(EmployeeCreateRequest request);

	EmployeeUpdateAndSetAccessResponse updateAndSetAccess(Integer employeeId,EmployeeUpdateAndSetAccessRequest request);
}
