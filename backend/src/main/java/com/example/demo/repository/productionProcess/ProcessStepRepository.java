package com.example.demo.repository.productionProcess;

import com.example.demo.model.productionProcess.ProcessStep;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProcessStepRepository extends JpaRepository<ProcessStep, Integer> {

    ProcessStep findById(int id);
}
