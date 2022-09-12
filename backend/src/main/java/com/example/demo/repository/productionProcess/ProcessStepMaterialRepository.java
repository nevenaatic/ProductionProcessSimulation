package com.example.demo.repository.productionProcess;

import com.example.demo.model.productionProcess.ProcessStepMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProcessStepMaterialRepository extends JpaRepository<ProcessStepMaterial, Integer> {
}
