package com.skillforge.recommender.controller;

import org.springframework.web.bind.annotation.RestController;

import com.skillforge.recommender.model.Candidate;
import com.skillforge.recommender.service.RecommendationService;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class RecommendationController {

    private final RecommendationService recommendationService;

    public RecommendationController(RecommendationService recommendationService) {
        this.recommendationService = recommendationService;

    }

    @GetMapping("/recommendCandidates/{jobId}")
    public List<Candidate> getMethodName(@PathVariable Long jobId) {
        return recommendationService.recommendCandidates(jobId);
    }

}
