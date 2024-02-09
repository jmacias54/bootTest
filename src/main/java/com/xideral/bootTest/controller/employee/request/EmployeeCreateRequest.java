package com.xideral.bootTest.controller.employee.request;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;


@Data
@Accessors(chain = true)
public class EmployeeCreateRequest {

	@NotNull(message = "consultingRoomId cannot be null")
	private final String name;

	@NotNull(message = "consultingRoomId cannot be null")
	private final String firstName;

	@NotNull(message = "consultingRoomId cannot be null")
	private final String lastName;

	@NotNull(message = "consultingRoomId cannot be null")
	private final Date birthDate;
}
