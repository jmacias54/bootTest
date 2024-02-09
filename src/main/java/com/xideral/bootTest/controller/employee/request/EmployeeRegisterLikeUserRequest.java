package com.xideral.bootTest.controller.employee.request;

import com.xideral.bootTest.controller.user.request.UserCreateRequest;
import lombok.Data;


@Data
public class EmployeeRegisterLikeUserRequest {

	private EmployeeCreateRequest employee;
	private UserCreateRequest user;

}
