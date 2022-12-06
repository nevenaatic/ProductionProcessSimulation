package com.example.demo.service.failure;

import com.example.demo.dto.failures.FailuresPreviewDto;
import com.example.demo.model.failure.Failure;
import com.example.demo.model.failure.FailureInProcessStep;
import com.example.demo.model.productionProcess.ProcessStep;
import com.example.demo.model.users.QualityEngineer;
import com.example.demo.repository.failure.FailureInProcessStepRepository;
import com.example.demo.service.productionProcess.ProcessStepService;
import com.example.demo.service.users.QualityEngineerService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FailureInProcessStepService {

    private FailureInProcessStepRepository failureInProcessStepRepository;
    private QualityEngineerService engineerService;
    private ProcessStepService processStepService;
    private FailureService failureService;

    public FailureInProcessStepService(FailureInProcessStepRepository failureInProcessStepRepository, QualityEngineerService engineerService,
                                       FailureService failureService, ProcessStepService processStepService) {
        this.failureInProcessStepRepository = failureInProcessStepRepository;
        this.engineerService = engineerService;
        this.failureService = failureService;
        this.processStepService = processStepService;
    }

    public FailureInProcessStep save(FailureInProcessStep failure) {
        return failureInProcessStepRepository.save(failure);
    }

    public FailureInProcessStep findById(int id) {
        return failureInProcessStepRepository.findById(id);
    }

    public void addFailureInPS(FailuresPreviewDto failure, int userId) {
        Failure newFailure = new Failure(failure);
        FailureInProcessStep newFailureInPS = new FailureInProcessStep();
        newFailure = failureService.save(newFailure);
        newFailureInPS.setFailure(newFailure);
        newFailureInPS.setProcessStep(processStepService.findStep(failure.id)); //used for processStep id in this case!
        save(newFailureInPS);
    }

    public List<FailureInProcessStep> getFailureForPS(int id) {
        List<FailureInProcessStep> failures = new ArrayList<>();
        for(FailureInProcessStep f: failureInProcessStepRepository.findAll() ){
            if(f.getProcessStep().getId() == id){
                failures.add(f);
            }
        }
        return failures;
    }

    public FailureInProcessStep getFailureWithFinalSteps(int id) {
       return  failureInProcessStepRepository.getFailureWithFinalList(id);
    }
}
