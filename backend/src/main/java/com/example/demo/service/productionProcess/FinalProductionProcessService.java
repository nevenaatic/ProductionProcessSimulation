package com.example.demo.service.productionProcess;

import com.example.demo.dto.process.UnfinishedProcessDto;
import com.example.demo.model.productionProcess.FinalProductionProcess;
import com.example.demo.repository.productionProcess.FinalProductionProcessRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class FinalProductionProcessService {

    private FinalProductionProcessRepository finalProductionProcessRepository;
    private FinalProcessStepService finalProcessStepService;
    private ProcessStepService processStepService;
    private ProductionProcessService productionProcessService;

    public FinalProductionProcessService(FinalProductionProcessRepository finalProductionProcessRepository,
                                         FinalProcessStepService finalProcessStepService, ProcessStepService processStepService,
                                         ProductionProcessService productionProcessService) {
        this.finalProductionProcessRepository = finalProductionProcessRepository;
        this.finalProcessStepService = finalProcessStepService;
        this.processStepService = processStepService;
        this.productionProcessService = productionProcessService;
    }


    public void startProcess(int id) {
        UnfinishedProcessDto process = productionProcessService.getProcessWithSteps(id);

    }

    public List<FinalProductionProcess> getAllForPeriodWithSteps(Date from, Date to){
        List<FinalProductionProcess> retWithSteps = new ArrayList<>();
        Calendar calFrom = Calendar.getInstance();
        calFrom.setTime(from);
        Calendar calTo = Calendar.getInstance();
        calTo.setTime(to);
        for(FinalProductionProcess fp: finalProductionProcessRepository.findAll()){
            Calendar processDate = Calendar.getInstance();
            processDate.setTime(fp.getDateStart());
                if( processDate.getTime().after(calFrom.getTime()) && processDate.getTime().before(calTo.getTime())){
                    retWithSteps.add(finalProductionProcessRepository.processWithFinalSteps(fp.getId()));
                }
        }
        return retWithSteps;
    }
}
