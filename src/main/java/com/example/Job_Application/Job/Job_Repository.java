package com.example.Job_Application.Job;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Job_Repository extends JpaRepository<Job,Long> {
}
