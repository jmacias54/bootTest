package com.xideral.bootTest.service;

import com.xideral.bootTest.controller.user.request.UserCreateRequest;

public interface UserService {

	Integer create(Integer employeeId, UserCreateRequest request);
}
