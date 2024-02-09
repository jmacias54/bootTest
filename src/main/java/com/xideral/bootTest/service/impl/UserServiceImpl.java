package com.xideral.bootTest.service.impl;

import com.xideral.bootTest.contract.Mapper;
import com.xideral.bootTest.controller.user.request.UserCreateRequest;
import com.xideral.bootTest.entities.User;
import com.xideral.bootTest.repository.UserRepository;
import com.xideral.bootTest.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;
	private final Mapper<UserCreateRequest, User> userCreateRequestToUserMapper;

	@Override
	public Integer create(Integer employeeId, UserCreateRequest request) {

		User user = this.userRepository.save(
			this.userCreateRequestToUserMapper.map(request).setEmployeeId(employeeId)
		);
		return user.getUserId();
	}
}
