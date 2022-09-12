package com.example.demo.repository.productionProcess;

import com.example.demo.model.productionProcess.FinalProcessStep;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;

@Repository
public interface FinalProcessStepRepository extends JpaRepository<FinalProcessStep, CriteriaBuilder.In> {
}
