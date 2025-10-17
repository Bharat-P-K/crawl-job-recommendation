package com.skillforge.recommender.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;
import com.skillforge.recommender.model.Candidate;
import com.skillforge.recommender.repository.CandidateRepository;
import com.skillforge.recommender.service.RecommendationService;

@RestController
@RequestMapping("/recommendCandidate")
public class CandidateController {

    private final CandidateRepository candidateRepository;
    private final RecommendationService recommendationService;

    public CandidateController(CandidateRepository candidateRepository, RecommendationService recommendationService) {
        this.candidateRepository = candidateRepository; // onstructor-based dependency injection
        this.recommendationService = recommendationService;

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
        return recommendationService.recommendCandidates(jobId);
    }

}