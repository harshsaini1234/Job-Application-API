package com.example.Job_Application.Job;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("/jobs")
public class Job_Controller {

    private Job_Service jobService;

    public Job_Controller(Job_Service jobService) {
        this.jobService = jobService;
    }

    @GetMapping
    public ResponseEntity<List<Job>> findAll(){
        return ResponseEntity.ok(jobService.findAll());
    }

    @PostMapping
    public ResponseEntity<String> createJob( @RequestBody Job job){
        jobService.createJob(job);
        return new ResponseEntity<>(" Job added successfully",HttpStatus.CREATED
                );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable Long id){
        Job job = jobService.findJobById(id);
        if (job!= null) {
            return new ResponseEntity<>(job, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteJob(@PathVariable Long id){
       boolean deleted = jobService.deleteJobById(id);
       if (deleted)
           return new ResponseEntity<>("Job successfully Deleted",HttpStatus.OK);
       else
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateJob(@PathVariable Long id ,
                                            @RequestBody Job updatedJob){
        boolean updated = jobService.updateJob(id,updatedJob);
        if (updated)
            return new ResponseEntity<>("updated successfully job",HttpStatus.OK);
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
