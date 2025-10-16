package com.skillforge.recommender.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.*;
import com.skillforge.recommender.model.Candidate;
import com.skillforge.recommender.model.Job;
import com.skillforge.recommender.repository.CandidateRepository;
import com.skillforge.recommender.repository.JobRepository;

@RestController
@RequestMapping("/recommendCandidate")
public class CandidateController {

    private final CandidateRepository candidateRepository;
    private final JobRepository jobRepository;

    public CandidateController(CandidateRepository candidateRepository, JobRepository jobRepository) {
        this.candidateRepository = candidateRepository;
        this.jobRepository = jobRepository;

    }

    @GetMapping
    public List<Candidate> getAllCanidates() {
        return candidateRepository.findAll();
    }

    @PostMapping
    public Candidate addCandidate(@RequestBody Candidate candidate) {

        return candidateRepository.save(candidate);
    }

    @GetMapping("/recommend")
    public List<Candidate> recommend(Long jobId) {

        Job job = jobRepository.findById(jobId).orElse(null);

        List<Candidate> allCandidates = candidateRepository.findAll();
        List<Candidate> matched = new ArrayList<Candidate>();

        for (Candidate cd : allCandidates) {
            if (cd.getExperience() >= job.getExperienceRequired() && job.getSkills().contains(cd.getSkills())) {
                matched.add(cd);
            }
        }
        return matched;
    }

}