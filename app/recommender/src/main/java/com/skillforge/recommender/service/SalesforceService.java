package com.skillforge.recommender.service;

import java.util.*;

import org.springframework.stereotype.Service;

import com.skillforge.recommender.model.Candidate;

@Service
public class SalesforceService {

    public List<Candidate> fetchCandidatesFromSalesforce() {
        Candidate c1 = new Candidate();

        c1.setName("Aaron Wright");
        c1.setLocation("Bangalore");
        c1.setExperience(5);
        c1.setSkills("Java, Spring Boot");

        Candidate c2 = new Candidate();

        c2.setName("Angela Baker");
        c2.setLocation("tampabay");
        c2.setExperience(6);
        c2.setSkills("React, Node.js");

        return Arrays.asList(c1, c2);

    }

}
