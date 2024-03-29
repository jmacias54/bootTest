package com.xideral.bootTest.controller.employee;

import com.xideral.bootTest.configuration.constant.GlobalConstants;
import com.xideral.bootTest.controller.employee.request.EmployeeCreateRequest;
import com.xideral.bootTest.controller.employee.request.EmployeeRegisterLikeUserRequest;
import com.xideral.bootTest.controller.employee.request.EmployeeUpdateAndSetAccessRequest;
import com.xideral.bootTest.controller.employee.request.EmployeeUpdateRequest;
import com.xideral.bootTest.controller.employee.response.EmployeeCreateResponse;
import com.xideral.bootTest.controller.employee.response.EmployeeUpdateAndSetAccessResponse;
import com.xideral.bootTest.controller.validation.UniqueUserEmployeeId;
import com.xideral.bootTest.entities.Employee;
import com.xideral.bootTest.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping(path = GlobalConstants.EMPLOYEES_ENDPOINT, produces = MediaType.APPLICATION_JSON_VALUE)
public class EmployeeController {

	private final EmployeeService employeeService;

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EmployeeCreateResponse> create(@RequestBody @Valid EmployeeCreateRequest request) {

		Integer id = this.employeeService.create(request);
		return ResponseEntity.ok(new EmployeeCreateResponse(id, Boolean.TRUE));
	}

	@PutMapping(path = "/{employeeId}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EmployeeUpdateAndSetAccessResponse> updateAndSetAccess(
		@PathVariable("employeeId") @UniqueUserEmployeeId(message = "user.employeeId.exist") Integer employeeId,
		@RequestBody @Valid EmployeeUpdateAndSetAccessRequest request
	) {
		return ResponseEntity.ok(this.employeeService.updateAndSetAccess(employeeId, request));
	}

	@PostMapping(path = "/addLikeSystemUser", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EmployeeUpdateAndSetAccessResponse> addLikeUser(
		@RequestBody @Valid EmployeeRegisterLikeUserRequest request
	) {
		return ResponseEntity.ok(this.employeeService.addLikeUser(request));
	}

	@PutMapping(path = "/updateAndRemoveAccess/{employeeId}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EmployeeCreateResponse> updateAndRemoveAccess(
		@PathVariable("employeeId") @UniqueUserEmployeeId(message = "user.employeeId.exist") Integer employeeId,
		@RequestBody @Valid EmployeeUpdateRequest request
	) {
		return ResponseEntity.ok(this.employeeService.updateAndRemoveAccess(employeeId, request));
	}


	@GetMapping(path = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Employee>> getAllEmployees() {
		return ResponseEntity.ok(this.employeeService.getAllEmployees());
	}


}
