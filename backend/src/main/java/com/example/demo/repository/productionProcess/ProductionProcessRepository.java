package com.example.demo.repository.productionProcess;

import com.example.demo.model.productionProcess.ProductionProcess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductionProcessRepository extends JpaRepository<ProductionProcess, Integer> {


    ProductionProcess save(ProductionProcess process);

    @Query("select p from ProductionProcess p where p.finished = false")
    List<ProductionProcess> unfinishedProcesses();

   // vraca tri puta isti proces?
//    @Query("select p from ProductionProcess p join fetch p.stepOfPPList ")
//    List<ProductionProcess> processWithSteps();

    @Query("select p from ProductionProcess p join fetch p.stepOfPPList s where p.id =?1")
    ProductionProcess processWithSteps(int id);
}
