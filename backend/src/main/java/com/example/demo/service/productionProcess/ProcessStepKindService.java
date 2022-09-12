package com.example.demo.service.productionProcess;

import com.example.demo.model.productionProcess.ProcessStepKind;
import com.example.demo.repository.productionProcess.ProcessStepKindRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProcessStepKindService {

    private ProcessStepKindRepository processStepKindRepository;

    public ProcessStepKindService(ProcessStepKindRepository processStepKindRepository){
        this.processStepKindRepository = processStepKindRepository;
    }

    public List<ProcessStepKind> getAll(){
        return processStepKindRepository.findAll();
    }

    public ProcessStepKind getByName(String name){
        return processStepKindRepository.getByName(name);
    }

    public ProcessStepKind getById(int id){
        return processStepKindRepository.findById(id);
    }

}
