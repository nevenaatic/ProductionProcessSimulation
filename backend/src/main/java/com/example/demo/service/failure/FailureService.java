package com.example.demo.service.failure;

import com.example.demo.dto.failures.FailuresPreviewDto;
import com.example.demo.model.failure.Failure;
import com.example.demo.model.users.User;
import com.example.demo.repository.failure.FailureRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FailureService {

    private FailureRepository failureRepository;

    private FailureInProcessStepService failureIPSService;

    public FailureService(FailureRepository failureRepository){
        this.failureRepository = failureRepository;
    }

    public List<Failure> getAll(){
        return failureRepository.findAll();
    }


    public Failure save(Failure failure) {
        return this.failureRepository.save(failure);
    }
}
