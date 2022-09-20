package com.example.demo.repository.productionProcess;

import com.example.demo.model.productionProcess.StepOfProductionProcess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StepOfProductionProcessRepository extends JpaRepository<StepOfProductionProcess, Integer> {

    @Query("select s from StepOfProductionProcess s where s.productionProcess.id = ?1 order by s.processStepNumber")
    List<StepOfProductionProcess> findStepsForProcess(int id);

    @Query("select s from StepOfProductionProcess s  join fetch s.finalProcessStepList fs where s.id = ?1")
    StepOfProductionProcess sofppWithFinalStepsList(int id);

}
