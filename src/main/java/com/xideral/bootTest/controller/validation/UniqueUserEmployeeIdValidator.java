package com.xideral.bootTest.controller.validation;

import com.xideral.bootTest.entities.User;
import com.xideral.bootTest.repository.UserRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
@RequiredArgsConstructor
public class UniqueUserEmployeeIdValidator implements ConstraintValidator<UniqueUserEmployeeId, Integer> {

	private final UserRepository userRepository;

	@Override
	public boolean isValid(Integer employeeId, ConstraintValidatorContext constraintValidatorContext) {
		Optional<User> userOptional = this.userRepository.findByEmployeeId(employeeId);
		return userOptional.isEmpty();
	}
}
