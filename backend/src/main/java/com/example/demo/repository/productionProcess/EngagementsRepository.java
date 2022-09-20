package com.example.demo.repository.productionProcess;

import com.example.demo.model.productionProcess.EmployeeWithEngagement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EngagementsRepository extends JpaRepository<EmployeeWithEngagement, Integer> {

    List<EmployeeWithEngagement> findById(int id);

    @Query("select e from EmployeeWithEngagement e join fetch e.employee en where e.id = ?1")
    List<EmployeeWithEngagement> getEngagementByEmployee(int idEmployee);
}
