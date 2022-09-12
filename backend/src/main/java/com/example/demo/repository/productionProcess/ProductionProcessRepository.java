package com.example.demo.repository.productionProcess;

import com.example.demo.model.productionProcess.ProductionProcess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductionProcessRepository extends JpaRepository<ProductionProcess, Integer> {


    ProductionProcess save(ProductionProcess process);
}
