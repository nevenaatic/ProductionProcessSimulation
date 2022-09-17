package com.example.demo.repository.failure;

import com.example.demo.model.failure.FailureInProcessStep;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FailureInProcessStepRepository extends JpaRepository<FailureInProcessStep, Integer> {
}
