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
        this.candidateRepository = candidateRepository; // onstructor-based dependency injection
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

    @GetMapping("/recommendForJob")
    public List<Candidate> recommend(@RequestParam Long jobId) {
        Job job = jobRepository.findById(jobId).orElse(null);
        if (job == null) {
            return new ArrayList<>();
        }

        List<Candidate> allCandidates = candidateRepository.findAll();
        List<Candidate> fitForJobRole = new ArrayList<>();

        for (Candidate cd : allCandidates) {
            // Convert job skills list to lowercase string for comparison
            String candidateSkills = cd.getSkills().toLowerCase();

            // Simple match: check if candidate has any job skill
            boolean skillMatch = false;
            for (String skill : job.getSkills()) {
                if (candidateSkills.contains(skill.toLowerCase())) {
                    skillMatch = true;
                    break;
                }
            }

            // Experience check: candidate should have >= required
            boolean experienceMatch = cd.getExperience() >= job.getExperienceRequired();

            if (skillMatch && experienceMatch) {
                fitForJobRole.add(cd);
            }
        }

        return fitForJobRole;
    }

}