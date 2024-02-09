package com.xideral.bootTest.service.impl;

import com.xideral.bootTest.contract.Mapper;
import com.xideral.bootTest.controller.employee.request.EmployeeCreateRequest;
import com.xideral.bootTest.controller.employee.request.EmployeeUpdateAndSetAccessRequest;
import com.xideral.bootTest.controller.employee.response.EmployeeUpdateAndSetAccessResponse;
import com.xideral.bootTest.entities.Employee;
import com.xideral.bootTest.exception.BadRequestException;
import com.xideral.bootTest.repository.EmployeeRepository;
import com.xideral.bootTest.service.EmployeeService;
import com.xideral.bootTest.service.UserService;
import com.xideral.bootTest.service.mapper.EmployeeUpdater;
import com.xideral.bootTest.service.validation.EmployeeIsUnique;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

	private final EmployeeRepository employeeRepository;
	private final UserService userService;
	private final EmployeeIsUnique employeeIsUnique;
	private final EmployeeUpdater employeeUpdater;
	private final Mapper<EmployeeCreateRequest, Employee> employeeCreateRequestToEmployeeMapper;

	@Override
	public Integer create(EmployeeCreateRequest request) {
		this.employeeIsUnique.isUnique(
			request.getName(),
			request.getFirstName(),
			request.getLastName()
		);

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

		this.employeeIsUnique.isUnique(
			request.getEmployee().getName(),
			request.getEmployee().getFirstName(),
			request.getEmployee().getLastName()
		);

		Optional<Employee> employee = this.employeeRepository.findById(employeeId);

		if(employee.isEmpty())
			throw new BadRequestException("Employee not exist.");

		employee = Optional.of(this.employeeRepository.save(
			this.employeeUpdater.updater(
				employeeId, employee.get(),
				request.getEmployee()
			)
		));

		Integer userId = this.userService.create(employeeId,request.getUser());

		return new EmployeeUpdateAndSetAccessResponse(userId,employeeId,Boolean.TRUE);
	}
}
