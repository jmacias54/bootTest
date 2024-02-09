package com.xideral.bootTest.controller.user.request;

import com.xideral.bootTest.controller.validation.UniqueUserEmail;
import com.xideral.bootTest.controller.validation.UniqueUserName;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class UserCreateRequest {

	@Schema(description = "name of employee", example = "Luis")
	@NotNull(message = "user.email.null")
	@NotBlank(message = "user.email.blank")
	@Size(min = 1, max = 100, message = "user.email.size")
	@UniqueUserEmail(message = "user.email.exist")
	private final String email;

	@Schema(description = "user name", example = "Luis")
	@NotNull(message = "user.name.null")
	@NotBlank(message = "user.name.blank")
	@Size(min = 1, max = 100, message = "user.name.size")
	@UniqueUserName(message = "user.name.exist")
	private final String name;

	@Schema(description = "password of user", example = "Batman")
	@NotNull(message = "user.password.null")
	@NotBlank(message = "user.password.blank")
	@Size(min = 1, max = 100, message = "user.password.size")
	private final String password;


}
