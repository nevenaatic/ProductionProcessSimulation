package com.example.demo.repository.failure;

import com.example.demo.model.failure.FailureInProcessStep;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FailureInProcessStepRepository extends JpaRepository<FailureInProcessStep, Integer> {

    @Query("select f from FailureInProcessStep f join fetch f.processStep ps where ps.id = ?1")
    List<FailureInProcessStep> getFailureForProcessStep(int stepId);

    @Query("select f from FailureInProcessStep f left join fetch f.finalProcessStepList fs where f.id = ?1")
   FailureInProcessStep getFailureWithFinalList(int id);

    FailureInProcessStep findById(int id);
}
