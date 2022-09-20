package com.example.demo.service.productionProcess;

import com.example.demo.model.productionProcess.FinalProcessStep;
import com.example.demo.repository.productionProcess.FinalProcessStepRepository;
import org.springframework.stereotype.Service;

@Service
public class FinalProcessStepService {

    private FinalProcessStepRepository finalProcessStepRepository;

    public FinalProcessStepService(FinalProcessStepRepository finalProcessStepRepository) {
        this.finalProcessStepRepository = finalProcessStepRepository;
    }

    public FinalProcessStep getStepWithEngagements(int idStep){
        FinalProcessStep step = finalProcessStepRepository.getFinalStepEngagements(idStep);
        return step;
    }

    public FinalProcessStep save(FinalProcessStep finalProcessStep) {
        return finalProcessStepRepository.save(finalProcessStep);
    }
}
