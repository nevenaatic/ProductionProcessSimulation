package com.example.demo.repository.users;

import com.example.demo.model.users.QualityEngineer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QualityEngineerRepository extends JpaRepository<QualityEngineer, Integer> {

    QualityEngineer findById(int id);
}
