package com.xideral.bootTest.service;

import com.xideral.bootTest.controller.user.request.UserCreateRequest;
import com.xideral.bootTest.entities.User;

import java.util.Optional;

public interface UserService {

	Integer create(Integer employeeId, UserCreateRequest request);

	Optional<User> findByEmployeeId(Integer employeeId);

	void deleteByEmployeeId(Integer employeeId);

}
