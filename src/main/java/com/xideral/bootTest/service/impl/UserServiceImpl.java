package com.xideral.bootTest.service.impl;

import com.xideral.bootTest.contract.Mapper;
import com.xideral.bootTest.controller.user.request.UserCreateRequest;
import com.xideral.bootTest.entities.User;
import com.xideral.bootTest.exception.BadRequestException;
import com.xideral.bootTest.repository.UserRepository;
import com.xideral.bootTest.service.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;
	private final Mapper<UserCreateRequest, User> userCreateRequestToUserMapper;

	@Override
	@Transactional
	public Integer create(Integer employeeId, UserCreateRequest request) {

		User user = this.userRepository.save(
			this.userCreateRequestToUserMapper.map(request).setEmployeeId(employeeId)
		);
		return user.getUserId();
	}

	@Override
	public Optional<User> findByEmployeeId(Integer employeeId) {
		return this.userRepository.findByEmployeeId(employeeId);
	}

	@Override
	@Transactional
	public void deleteByEmployeeId(Integer employeeId) {
		Optional<User> user = this.userRepository.findByEmployeeId(employeeId);

		if(user.isEmpty())
			throw new BadRequestException(String.format("User not exist with empliyeeId : %d", employeeId));

		this.userRepository.delete(user.get());
	}
}
