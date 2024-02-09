package com.xideral.bootTest.service;

import com.xideral.bootTest.controller.employee.request.EmployeeCreateRequest;

public interface EmployeeService {

	Integer create(EmployeeCreateRequest request);
}
