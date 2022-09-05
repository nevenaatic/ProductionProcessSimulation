package com.example.demo.repository.failure;

import com.example.demo.model.failure.Failure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FailureRepository extends JpaRepository<Failure,Integer> {

}
