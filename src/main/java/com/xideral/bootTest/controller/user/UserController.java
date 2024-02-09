package com.xideral.bootTest.controller.user;

import com.xideral.bootTest.configuration.constant.GlobalConstants;
import com.xideral.bootTest.controller.user.request.UserAsingAreaRequest;
import com.xideral.bootTest.controller.user.response.UserAsingAreaResponse;
import com.xideral.bootTest.entities.User;
import com.xideral.bootTest.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping(path = GlobalConstants.USERS_ENDPOINT, produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

	private final UserService userService;

	@GetMapping(path = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<User>> getAllUsers() {
		return ResponseEntity.ok(this.userService.getAllUsers());
	}

	@PostMapping(path = "/asingArea", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserAsingAreaResponse> asingArea(@RequestBody @Valid UserAsingAreaRequest request) {
		return ResponseEntity.ok(this.userService.asingArea(request));
	}





}
