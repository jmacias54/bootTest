package com.xideral.bootTest.controller.employee.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.xideral.bootTest.controller.validation.UniqueNameAndFirstNameAndLastName;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@Accessors(chain = true)
@Schema(description = "Employee Update Request")
@UniqueNameAndFirstNameAndLastName(message = "employee.nonUnique")
public class EmployeeUpdateRequest {

	@Schema(description = "name of employee", example = "Luis")
	@NotNull(message = "employee.name.null")
	@NotBlank(message = "employee.name.blank")
	@Size(min = 1, max = 100, message = "employee.name.size")
	private final String name;

	@Schema(description = "first name of employee", example = "Diaz")
	@NotNull(message = "employee.firstName.null")
	@NotBlank(message = "employee.firstName.blank")
	@JsonProperty("first_name")
	@Size(min = 1, max = 100, message = "employee.firstName.size")
	private final String firstName;


	@Schema(description = "last name of employee", example = "Lopez")
	@NotNull(message = "employee.lastname.null")
	@NotBlank(message = "employee.lastName.blank")
	@Size(min = 1, max = 100, message = "employee.lastname.size")
	@JsonProperty("last_name")
	private final String lastName;

	@NotNull(message = "employee.birthdate.null")
	@JsonProperty("birthdate")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Past
	private final Date birthDate;
}
