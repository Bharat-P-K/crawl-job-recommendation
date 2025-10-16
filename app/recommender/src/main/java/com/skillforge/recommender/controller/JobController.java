package com.skillforge.recommender.controller;

import com.skillforge.recommender.model.Job;
import com.skillforge.recommender.repository.JobRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobController {

    private final JobRepository jobRepository;

    public JobController(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @GetMapping
    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    @PostMapping
    public Job addJob(@RequestBody Job job) {
        return jobRepository.save(job);
    }

    @GetMapping("/jobDetails")
    public Job getJobDetails(@RequestParam Long jobId) {
        return jobRepository.findById(jobId).orElse(null);
    }

}
