package com.example.Job_Application.Job.Imp;

import com.example.Job_Application.Job.Job;
import com.example.Job_Application.Job.Job_Service;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class Job_Service_Implement implements Job_Service {
    private List<Job> jobs = new ArrayList<>();
    private Long nextId=1L;



    @Override
    public List<Job> findAll() {
        return jobs;
    }

    @Override
    public void createJob(Job job) {
        job.setId(nextId++);
        jobs.add(job);

    }

    @Override
    public Job findJobById(Long id) {
        for (Job job : jobs){
            if (job.getId().equals(id)){
                return job;
            }
        }
        return null;
    }
}
