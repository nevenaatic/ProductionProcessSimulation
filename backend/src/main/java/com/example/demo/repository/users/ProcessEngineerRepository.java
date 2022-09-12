package com.example.demo.repository.users;

import com.example.demo.model.productionProcess.ProductionProcess;
import com.example.demo.model.users.ProcessEngineer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProcessEngineerRepository extends JpaRepository<ProcessEngineer, Integer> {

    ProcessEngineer findById(int id);

    @Query("select e from ProcessEngineer e left join fetch e.productionProcessList pp where e.id = ?1")
    ProcessEngineer engineerWithProcesses(int id);

}
