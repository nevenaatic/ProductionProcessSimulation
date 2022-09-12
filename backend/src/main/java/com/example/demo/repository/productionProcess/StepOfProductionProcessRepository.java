package com.example.demo.repository.productionProcess;

import com.example.demo.model.productionProcess.StepOfProductionProcess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StepOfProductionProcessRepository extends JpaRepository<StepOfProductionProcess, Integer> {
}
