package com.example.demo.service.users;

import com.example.demo.model.productionProcess.ProductionProcess;
import com.example.demo.model.users.ProcessEngineer;
import com.example.demo.repository.users.ProcessEngineerRepository;
import org.springframework.stereotype.Service;

@Service
public class ProcessEngineerService {

    private ProcessEngineerRepository engineerRepository;

    public ProcessEngineerService(ProcessEngineerRepository engineerRepository) {
        this.engineerRepository = engineerRepository;
    }

    public ProcessEngineer getById(int id) {
        return this.engineerRepository.findById(id);
    }

    public ProcessEngineer engineerWithProcessList(int id){
        return this.engineerRepository.engineerWithProcesses(id);
    }
}
