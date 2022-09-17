package com.example.demo.service.productionProcess;

import com.example.demo.model.failure.Failure;
import com.example.demo.model.productionProcess.StepOfProductionProcess;
import com.example.demo.repository.productionProcess.StepOfProductionProcessRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StepOfProductionProcessService {

    private StepOfProductionProcessRepository stepOfProductionProcessRepository;

    public StepOfProductionProcessService(StepOfProductionProcessRepository stepOfProductionProcess) {
        this.stepOfProductionProcessRepository = stepOfProductionProcess;
    }

    //finish
    public void addFailure(int id, Failure failure){
        StepOfProductionProcess stepOfProductionProcess = stepOfProductionProcessRepository.getById(id);

    }

    public List<StepOfProductionProcess> findStepsForProcess(int id){
        return stepOfProductionProcessRepository.findStepsForProcess(id);
    }

    public StepOfProductionProcess save(StepOfProductionProcess stepOfProductionProcess) {
        return this.stepOfProductionProcessRepository.save(stepOfProductionProcess);
    }
}
