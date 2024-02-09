package com.xideral.bootTest.controller.validation;

import com.xideral.bootTest.repository.UserRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class UniqueUserNameValidator implements ConstraintValidator<UniqueUserName, String> {

	private final UserRepository userRepository;

	@Override
	public boolean isValid(String name, ConstraintValidatorContext constraintValidatorContext) {
		return this.userRepository.findByUserName(name).isPresent();
	}
}
