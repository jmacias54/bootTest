package com.xideral.bootTest.service.impl;

import com.xideral.bootTest.repository.UserRepository;
import com.xideral.bootTest.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;

}
