package com.example.demo.service.users;

import com.example.demo.model.users.QualityEngineer;
import com.example.demo.repository.users.QualityEngineerRepository;
import org.springframework.stereotype.Service;

@Service
public class QualityEngineerService {

    public QualityEngineerRepository qualityEngineerRepository;

    public QualityEngineerService(QualityEngineerRepository qualityEngineerRepository) {
        this.qualityEngineerRepository = qualityEngineerRepository;
    }

    public QualityEngineer findById(int id){
        return qualityEngineerRepository.findById(id);
    }

    public QualityEngineer findWithProducts(int id){
        return this.qualityEngineerRepository.findWithProducts(id);
    }
}
