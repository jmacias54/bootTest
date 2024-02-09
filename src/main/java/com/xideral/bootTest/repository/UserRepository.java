package com.xideral.bootTest.repository;

import com.xideral.bootTest.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	Optional<User> findByUserEmail(String email);

	Optional<User> findByUserName(String name);

	Optional<User> findByEmployeeId(Integer employeeId);


}
