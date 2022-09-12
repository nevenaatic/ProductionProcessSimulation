package com.example.demo.repository.productionProcess;

import com.example.demo.model.productionProcess.ProcessStepKind;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProcessStepKindRepository extends JpaRepository<ProcessStepKind, Integer> {
    ProcessStepKind getByName(String name);

    ProcessStepKind findById(int id);
}
