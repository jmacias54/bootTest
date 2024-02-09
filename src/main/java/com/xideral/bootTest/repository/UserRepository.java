package com.xideral.bootTest.repository;

import com.xideral.bootTest.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository  extends JpaRepository<User, Integer> {

}
