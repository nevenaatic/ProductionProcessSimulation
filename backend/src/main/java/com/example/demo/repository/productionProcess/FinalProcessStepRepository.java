package com.example.demo.repository.productionProcess;

import com.example.demo.model.productionProcess.FinalProcessStep;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;

@Repository
public interface FinalProcessStepRepository extends JpaRepository<FinalProcessStep, CriteriaBuilder.In> {

    @Query("select fs from FinalProcessStep fs left join fetch fs.employeesWithEngagements ee where fs.id = ?1")
    FinalProcessStep getFinalStepEngagements(int idStep);

    FinalProcessStep getById(int id);
}
