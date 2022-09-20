package com.example.demo.service.productionProcess;


import com.example.demo.dto.engagements.EngagementRequestDto;
import com.example.demo.dto.engagements.EngagementsByEmployeeDto;
import com.example.demo.dto.engagements.EngagementsStepsDto;
import com.example.demo.model.productionProcess.EmployeeWithEngagement;
import com.example.demo.model.productionProcess.FinalProcessStep;
import com.example.demo.model.productionProcess.FinalProductionProcess;
import com.example.demo.repository.productionProcess.EngagementsRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EngagementService {

    private EngagementsRepository engagementsRepository;
    private FinalProductionProcessService finalProcessService;
    private FinalProcessStepService finalProcessStepService;

    public EngagementService(EngagementsRepository engagementsRepository, FinalProductionProcessService finalProcessService, FinalProcessStepService finalProcessStepService) {
        this.engagementsRepository = engagementsRepository;
        this.finalProcessService = finalProcessService;
        this.finalProcessStepService = finalProcessStepService;
    }

    public List<EmployeeWithEngagement> getAll() {
        return engagementsRepository.findAll();
    }

    public List<EngagementsByEmployeeDto> getEngagementForPeriod(EngagementRequestDto dto) {
        List<FinalProductionProcess> allProcesses = finalProcessService.getAllForPeriodWithSteps(dto.from, dto.to);
        List<EngagementsByEmployeeDto> ret = new ArrayList<>();

        for (FinalProductionProcess fp : allProcesses) {
            EngagementsByEmployeeDto engagement = new EngagementsByEmployeeDto();
            List<EngagementsStepsDto> stepsForOneProcess = new ArrayList<>();

            for (FinalProcessStep fps : fp.getFinalProcessStepList()) {
                FinalProcessStep fpsWithEngagements = finalProcessStepService.getStepWithEngagements(fps.getId());

                for (EmployeeWithEngagement e : fpsWithEngagements.getEmployeesWithEngagements()) {

                    if (e.getEmployee().getId() == dto.idEmployee) {
                        if (fps.getFailureInPS() != null) {
                            EngagementsStepsDto stepsDto = new EngagementsStepsDto(fps.getId(), fps.getStepOfPP().getProcessStep().getName(), true,e.getHours());
                            engagement.engagementsStepsDtoList.add(stepsDto);
                            engagement.failed = true;
                        } else {
                            EngagementsStepsDto stepsDto = new EngagementsStepsDto(fps.getId(), fps.getStepOfPP().getProcessStep().getName(), false, e.getHours());
                            stepsForOneProcess.add(stepsDto);
                            engagement.failed = false;
                        }
                    }
                }
            }
            engagement.engagementsStepsDtoList=stepsForOneProcess;
            engagement.processLabel = fp.getLabel();
            engagement.dateStart = fp.getDateStart();
            engagement.processName = fp.getProductionProcess().getName();
            ret.add(engagement);
        }
        return ret;
    }


    public void save(EmployeeWithEngagement engagement) {
        engagementsRepository.save(engagement);
    }
}