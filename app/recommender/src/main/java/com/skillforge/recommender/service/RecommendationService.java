package com.skillforge.recommender.service;

import org.springframework.stereotype.Service;

import com.skillforge.recommender.model.Candidate;
import com.skillforge.recommender.model.Job;
import com.skillforge.recommender.repository.JobRepository;

import java.util.*;

@Service
public class RecommendationService {

    private final JobRepository jobRepository;
    private final SalesforceService salesforceService;

    public RecommendationService(SalesforceService salesforceService,
            JobRepository jobRepository) {
        this.salesforceService = salesforceService;
        this.jobRepository = jobRepository;
    }

    // public List<Candidate> recommendCandidate(Job job, List<Candidate>
    // Candidates){

    public List<Candidate> recommendCandidates(Long jobId) {
        Job job = jobRepository.findById(jobId).orElse(null);
        if (job == null)
            return new ArrayList<>();

        List<Candidate> allCandidates = salesforceService.fetchCandidatesFromSalesforce();
        List<Candidate> matched = new ArrayList<>();

        for (Candidate candidate : allCandidates) {
            if (candidate.getSkills() != null &&
                    candidate.getSkills().toLowerCase().contains(
                            job.getSkills().get(0).toLowerCase())) {
                matched.add(candidate);
            }
        }
        return matched;
    }
}
