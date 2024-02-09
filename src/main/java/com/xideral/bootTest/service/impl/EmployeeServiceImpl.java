package com.xideral.bootTest.service.impl;

import com.xideral.bootTest.contract.Mapper;
import com.xideral.bootTest.controller.employee.request.EmployeeCreateRequest;
import com.xideral.bootTest.controller.employee.request.EmployeeRegisterLikeUserRequest;
import com.xideral.bootTest.controller.employee.request.EmployeeUpdateAndSetAccessRequest;
import com.xideral.bootTest.controller.employee.request.EmployeeUpdateRequest;
import com.xideral.bootTest.controller.employee.response.EmployeeCreateResponse;
import com.xideral.bootTest.controller.employee.response.EmployeeUpdateAndSetAccessResponse;
import com.xideral.bootTest.entities.Employee;
import com.xideral.bootTest.exception.BadRequestException;
import com.xideral.bootTest.exception.ItemNotFoundException;
import com.xideral.bootTest.repository.EmployeeRepository;
import com.xideral.bootTest.service.EmployeeService;
import com.xideral.bootTest.service.UserService;
import com.xideral.bootTest.service.mapper.EmployeeUpdater;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.Objects.isNull;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

	private final EmployeeRepository employeeRepository;
	private final UserService userService;
	private final EmployeeUpdater employeeUpdater;
	private final Mapper<EmployeeCreateRequest, Employee> employeeCreateRequestToEmployeeMapper;

	@Override
	public Integer create(EmployeeCreateRequest request) {
		Employee employee = this.employeeRepository.save(
			this.employeeCreateRequestToEmployeeMapper.map(request)
		);
		return employee.getEmployeeId();
	}

	@Override
	@Transactional
	public EmployeeUpdateAndSetAccessResponse updateAndSetAccess(
		Integer employeeId,
		EmployeeUpdateAndSetAccessRequest request
	) {


		Optional<Employee> employee = this.updateEmployee(employeeId, request.getEmployee());
		Integer userId = this.userService.create(employeeId, request.getUser());

		return new EmployeeUpdateAndSetAccessResponse(userId, employeeId, Boolean.TRUE);
	}

	private Optional<Employee> updateEmployee(
		Integer employeeId,
		EmployeeUpdateRequest employeeUpdateRequest
	) {
		Optional<Employee> employee = this.employeeRepository.findById(employeeId);

		if(employee.isEmpty())
			throw new BadRequestException("Employee not exist.");

		return Optional.of(this.employeeRepository.save(
			this.employeeUpdater.updater(
				employeeId, employee.get(),
				employeeUpdateRequest
			)
		));
	}

	@Override
	@Transactional
	public EmployeeUpdateAndSetAccessResponse addLikeUser(EmployeeRegisterLikeUserRequest request) {
		Integer employeeId = this.create(request.getEmployee());

		if(isNull(employeeId))
			throw new ItemNotFoundException("Error insert employee.");

		Integer userId = this.userService.create(employeeId, request.getUser());

		if(isNull(userId))
			throw new ItemNotFoundException("Error insert user.");

		return new EmployeeUpdateAndSetAccessResponse(userId, employeeId, Boolean.TRUE);

	}


	@Override
	@Transactional
	public EmployeeCreateResponse updateAndRemoveAccess(
		Integer employeeId,
		EmployeeUpdateRequest request
	) {
		Optional<Employee> employee = this.updateEmployee(employeeId, request);

		this.userService.deleteByEmployeeId(employee.get().getEmployeeId());

		return new EmployeeCreateResponse(employeeId, Boolean.TRUE);

	}

	@Override
	public List<Employee> getAllEmployees() {
		return this.employeeRepository.findAll();
	}
}
