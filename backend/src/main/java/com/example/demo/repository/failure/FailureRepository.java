package com.example.demo.repository.failure;

import com.example.demo.model.failure.Failure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FailureRepository extends JpaRepository<Failure,Integer> {

    @Query("select f from Failure f left join fetch f.failureInPSList fps where f.id= ?1")
    Failure getWithFPSList(int id);
}
