package com.xideral.bootTest.controller.employee.request;

import com.xideral.bootTest.controller.user.request.UserCreateRequest;
import lombok.Data;


@Data
public class EmployeeUpdateAndSetAccessRequest {

	private EmployeeUpdateRequest employee;
	private UserCreateRequest user;

}
