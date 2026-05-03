package com.example.Job_Application.Job.Imp;

import com.example.Job_Application.Job.Job;
import com.example.Job_Application.Job.Job_Repository;
import com.example.Job_Application.Job.Job_Service;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class Job_Service_Implement implements Job_Service {
//    private List<Job> jobs = new ArrayList<>();
    Job_Repository job_repository;
    private Long nextId=1L;

    public Job_Service_Implement(Job_Repository job_repository) {
        this.job_repository = job_repository;
    }

    @Override
    public List<Job> findAll() {
        return job_repository.findAll();
    }

    @Override
    public void createJob(Job job) {
        job_repository.save(job);

    }

    @Override
    public Job findJobById(Long id) {
       return job_repository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteJobById(Long id) {
        try {
            job_repository.deleteById(id);
            return true;
        }
        catch (Exception e){
            return false;
        }

        }




    @Override
    public boolean updateJob(Long id, Job updatedJob) {

        Optional<Job> jobOptional = job_repository.findById(id);

            if (jobOptional.isPresent()){
                Job job = jobOptional.get();
                job.setTitle(updatedJob.getTitle());
                job.setDescription(updatedJob.getDescription());
                job.setMinSalary(updatedJob.getMinSalary());
                job.setMaxSalary(updatedJob.getMaxSalary());
                job.setLocation(updatedJob.getLocation());
                job_repository.save(job);
                return true;

            }

        return false;
    }
}
