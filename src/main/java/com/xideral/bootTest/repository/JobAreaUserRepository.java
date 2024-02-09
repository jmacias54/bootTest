package com.xideral.bootTest.repository;


import com.xideral.bootTest.entities.JobAreaUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobAreaUserRepository extends JpaRepository<JobAreaUser, Long> {
}
