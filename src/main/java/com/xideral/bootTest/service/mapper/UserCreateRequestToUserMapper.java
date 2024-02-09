package com.xideral.bootTest.service.mapper;

import com.xideral.bootTest.contract.Mapper;
import com.xideral.bootTest.controller.user.request.UserCreateRequest;
import com.xideral.bootTest.entities.User;
import org.springframework.stereotype.Component;

@Component
public class UserCreateRequestToUserMapper implements Mapper<UserCreateRequest, User> {
	public User map(UserCreateRequest request, Integer employeeId) {
		return new User()
			.setEmployeeId(employeeId)
			.setUserEmail(request.getEmail())
			.setUserName(request.getName())
			.setUserPassword(request.getPassword());
	}

	@Override
	public User map(UserCreateRequest request) {
		return new User()
			.setUserEmail(request.getEmail())
			.setUserName(request.getName())
			.setUserPassword(request.getPassword());
	}
}
