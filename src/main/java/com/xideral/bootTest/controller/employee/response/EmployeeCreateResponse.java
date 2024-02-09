package com.xideral.bootTest.controller.employee.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Accessors(chain = true)
public class EmployeeCreateResponse {

	private final Integer id;
	private final Boolean success;

}
