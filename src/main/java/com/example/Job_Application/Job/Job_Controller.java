package com.example.Job_Application.Job;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
@RestController
public class Job_Controller {

    private Job_Service jobService;

    public Job_Controller(Job_Service jobService) {
        this.jobService = jobService;
    }

    @GetMapping("/jobs")
    public List<Job> findAll(){
        return jobService.findAll();
    }

    @PostMapping("/jobs")
    public String createJob( @RequestBody Job job){
        jobService.createJob(job);
        return " Job added successfully";
    }
    /*
    Get/jobs : Get All jobs
    Get/jobs/{id}; Get a specific job by Id
    Post/jobs; Create a new job (request body should contain only job details )
    Delete/jobs/{id};Delete specific job by id
    Put/johbs/{id}; update a specific job by id ( request body should contain the update job)

     Job - Application api
     */
}
