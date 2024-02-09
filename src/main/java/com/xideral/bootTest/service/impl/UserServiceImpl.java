package com.xideral.bootTest.service.impl;

import com.xideral.bootTest.contract.Mapper;
import com.xideral.bootTest.controller.user.request.UserAsingAreaRequest;
import com.xideral.bootTest.controller.user.request.UserCreateRequest;
import com.xideral.bootTest.controller.user.response.UserAsingAreaResponse;
import com.xideral.bootTest.entities.JobArea;
import com.xideral.bootTest.entities.JobAreaUser;
import com.xideral.bootTest.entities.User;
import com.xideral.bootTest.exception.BadRequestException;
import com.xideral.bootTest.repository.JobAreaRepository;
import com.xideral.bootTest.repository.JobAreaUserRepository;
import com.xideral.bootTest.repository.UserRepository;
import com.xideral.bootTest.service.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;
	private final JobAreaRepository jobAreaRepository;
	private final JobAreaUserRepository jobAreaUserRepository;
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
			throw new BadRequestException(String.format("User not exist with employeeId : %d", employeeId));

		this.userRepository.delete(user.get());
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	@Transactional
	public UserAsingAreaResponse asingArea(UserAsingAreaRequest request) {

		Optional<User> user = this.userRepository.findById(request.getUserId());

		if(user.isEmpty())
			throw new BadRequestException("User not exist.");

		Optional<JobArea> area = this.jobAreaRepository.findById(request.getAreaId());
		if(area.isEmpty())
			throw new BadRequestException("Area not exist.");


		JobAreaUser jobAreaUser = this.jobAreaUserRepository.save(new JobAreaUser(area.get(), user.get()));

		return new UserAsingAreaResponse().setUserAreaId(jobAreaUser.getId());
	}

}
