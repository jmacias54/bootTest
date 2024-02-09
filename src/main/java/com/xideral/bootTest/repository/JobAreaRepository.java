package com.xideral.bootTest.repository;

import com.xideral.bootTest.entities.JobArea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobAreaRepository extends JpaRepository<JobArea, Long> {
}
