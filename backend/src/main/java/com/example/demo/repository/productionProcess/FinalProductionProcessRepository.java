package com.example.demo.repository.productionProcess;

import com.example.demo.model.productionProcess.FinalProductionProcess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FinalProductionProcessRepository extends JpaRepository<FinalProductionProcess, Integer> {

}
