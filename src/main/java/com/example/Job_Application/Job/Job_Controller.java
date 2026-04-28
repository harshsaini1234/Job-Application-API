package com.example.Job_Application.Job;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
public class Job_Controller {

    private Job_Service jobService;

    public Job_Controller(Job_Service jobService) {
        this.jobService = jobService;
    }

    @GetMapping("/jobs")
    public ResponseEntity<List<Job>> findAll(){
        return ResponseEntity.ok(jobService.findAll());
    }

    @PostMapping("/jobs")
    public ResponseEntity<String> createJob( @RequestBody Job job){
        jobService.createJob(job);
        return new ResponseEntity<>(" Job added successfully",HttpStatus.CREATED);
    }

    @GetMapping("/jobs/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable Long id){
        Job job = jobService.findJobById(id);
        if (job!= null) {
            return new ResponseEntity<>(job, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    /*
    Get/jobs : Get All jobs
    Get/jobs/{id}; Get a specific job by id
    Post/jobs; Create a new job (request body should contain only job details )
    Delete/jobs/{id};Delete specific job by id
    Put/johbs/{id}; update a specific job by id ( request body should contain the update job)

     Job - Application api
     */
}
