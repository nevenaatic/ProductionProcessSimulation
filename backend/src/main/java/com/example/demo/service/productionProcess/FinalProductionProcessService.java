package com.example.demo.service.productionProcess;

import com.example.demo.repository.productionProcess.FinalProductionProcessRepository;
import org.springframework.stereotype.Service;

@Service
public class FinalProductionProcessService {

    private FinalProductionProcessRepository finalProductionProcessRepository;

    public FinalProductionProcessService(FinalProductionProcessRepository finalProductionProcessRepository) {
        this.finalProductionProcessRepository = finalProductionProcessRepository;
    }
}
