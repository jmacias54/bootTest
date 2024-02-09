package com.xideral.bootTest.service.impl;

import com.xideral.bootTest.contract.Mapper;
import com.xideral.bootTest.controller.employee.request.EmployeeCreateRequest;
import com.xideral.bootTest.entities.Employee;
import com.xideral.bootTest.repository.EmployeeRepository;
import com.xideral.bootTest.service.EmployeeService;
import com.xideral.bootTest.service.validation.EmployeeIsUnique;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

	private final EmployeeRepository employeeRepository;
	private final EmployeeIsUnique employeeIsUnique;
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
}
