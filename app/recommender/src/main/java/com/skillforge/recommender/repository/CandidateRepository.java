package com.skillforge.recommender.repository;

import com.skillforge.recommender.model.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateRepository extends JpaRepository<Candidate, Long> {
        // Spring auto-creates methods like findAll(), findById(), save(), delete()

}
