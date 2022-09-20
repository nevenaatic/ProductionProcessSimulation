package com.example.demo.repository.productionProcess;

import com.example.demo.model.productionProcess.FinalProductionProcess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FinalProductionProcessRepository extends JpaRepository<FinalProductionProcess, Integer> {

    @Query("select f from FinalProductionProcess f left join fetch f.finalProcessStepList fs where f.id = ?1")
    FinalProductionProcess processWithFinalSteps(int idProcess);

}
