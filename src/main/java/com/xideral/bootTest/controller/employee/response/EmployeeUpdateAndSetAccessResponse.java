package com.xideral.bootTest.controller.employee.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@AllArgsConstructor
public class EmployeeUpdateAndSetAccessResponse {

	private final Integer userId;
	private final Integer employeeId;
	private final boolean success;
}
