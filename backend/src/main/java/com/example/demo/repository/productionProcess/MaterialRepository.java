package com.example.demo.repository.productionProcess;

import com.example.demo.model.others.Material;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MaterialRepository extends JpaRepository<Material, Integer> {

    @Query("select m from Material m join fetch m.processSteps s where s.id =?1")
    List<Material> getMaterialForSteps(int id);

}
