package com.banasiak.CalCount.repo;

import com.banasiak.CalCount.model.Grams;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GramsRepo extends JpaRepository<Grams, Long> {
}
