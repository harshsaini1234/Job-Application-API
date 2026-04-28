package com.example.Job_Application.Job;

import org.springframework.stereotype.Service;

import java.util.List;


public interface Job_Service {
    List<Job> findAll();
    void createJob(Job job);

    Job findJobById(Long id);
}
