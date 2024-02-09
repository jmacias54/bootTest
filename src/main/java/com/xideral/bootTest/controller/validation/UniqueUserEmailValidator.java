package com.xideral.bootTest.controller.validation;

import com.xideral.bootTest.repository.UserRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class UniqueUserEmailValidator implements ConstraintValidator<UniqueUserEmail, String> {

	private final UserRepository userRepository;

	@Override
	public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {
		return this.userRepository.findByUserName(email).isPresent();
	}
}
