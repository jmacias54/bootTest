package com.xideral.bootTest.controller.user.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@Schema(description = "User Asing Area Request")
public class UserAsingAreaRequest {

	private final Integer userId;
	private final Long areaId;
}
