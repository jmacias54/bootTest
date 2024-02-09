package com.xideral.bootTest.controller.user.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@Schema(description = "User Asing Area Response")
public class UserAsingAreaResponse {

	private Long userAreaId;
}
