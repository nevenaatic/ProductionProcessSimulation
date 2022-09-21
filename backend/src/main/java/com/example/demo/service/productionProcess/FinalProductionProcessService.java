package com.example.demo.service.productionProcess;

import com.example.demo.dto.process.UnfinishedProcessDto;
import com.example.demo.enums.ProductType;
import com.example.demo.model.product.FinalProduct;
import com.example.demo.model.productionProcess.*;
import com.example.demo.model.users.Employee;
import com.example.demo.repository.product.FinalProductRepository;
import com.example.demo.repository.productionProcess.EngagementsRepository;
import com.example.demo.repository.productionProcess.FinalProductionProcessRepository;
import com.example.demo.service.users.EmployeeService;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class FinalProductionProcessService {

    private FinalProductionProcessRepository finalProductionProcessRepository;
    private FinalProcessStepService finalProcessStepService;
    private ProcessStepService processStepService;
    private ProductionProcessService productionProcessService;
    private StepOfProductionProcessService stepOfProductionProcessService;
    private EmployeeService employeeService;
    private FinalProductRepository finalProductRepository;
    private EngagementsRepository engagementsRepository;

    public FinalProductionProcessService(FinalProductionProcessRepository finalProductionProcessRepository,
                                         FinalProcessStepService finalProcessStepService, ProcessStepService processStepService,
                                         ProductionProcessService productionProcessService,
                                         StepOfProductionProcessService stepOfProductionProcessService,
                                         EmployeeService employeeService, EngagementsRepository engagementsRepository,
                                         FinalProductRepository finalProductRepository) {
        this.finalProductionProcessRepository = finalProductionProcessRepository;
        this.finalProcessStepService = finalProcessStepService;
        this.processStepService = processStepService;
        this.productionProcessService = productionProcessService;
        this.stepOfProductionProcessService = stepOfProductionProcessService;
        this.employeeService = employeeService;
        this.engagementsRepository = engagementsRepository;
        this.finalProductRepository = finalProductRepository;
    }

    //without failure
    public void startProcess(int id) {
        ProductionProcess process = productionProcessService.getProcessWithFinalList(id);
        List<StepOfProductionProcess> stepsOfProcess = stepOfProductionProcessService.stepsForProcessAndFinalStepList(id);
        FinalProductionProcess finalProductionProcess = new FinalProductionProcess();
        finalProductionProcess.setLabel(RandomStringUtils.randomAlphabetic(8));
        finalProductionProcess.setDateStart(new Date());
        finalProductionProcess.setProductionProcess(process); //setovala sam nadjeni proces njemu
        finalProductionProcess = finalProductionProcessRepository.save(finalProductionProcess);  //setovala sam sad na njega samog

        List<Employee> employees = employeeService.getEmployeesWithEngagements();
        Random rand = new Random();

        for (StepOfProductionProcess s : stepsOfProcess) {
            FinalProcessStep finalProcessStep = new FinalProcessStep();
            finalProcessStep.setFinalProductionProcess(finalProductionProcess);
            finalProcessStep.setStepOfPP(s); //mozda treba da ga prvo sacuvam pa tek onda dodelim tom stepu
            finalProcessStep.setDateStart(new Date());
            finalProcessStep = finalProcessStepService.save(finalProcessStep);

            for (int i = 1; i <= s.getProcessStep().getProcessStepKind().getNumberOfPeople(); i++) {
                EmployeeWithEngagement engagement = new EmployeeWithEngagement();
                Employee employee = employeeService.getEmployeeWithEngagement(i + 1);
                engagement.setEmployee(employee);
                engagement.setHours(Math.round((1.0 + (5 - 1.0) * rand.nextDouble()) * 10.0) / 10.0); //maksimum ce biti pet sati za sve
                engagement.setFinalProcessStep(finalProcessStep);
                engagementsRepository.save(engagement);
            }

        }

        FinalProduct finalProduct = new FinalProduct();
        finalProduct.setProductForFinal(process.getProduct());
        finalProduct.setChecked(false);
        finalProduct.setProductType(ProductType.REGULAR);
        finalProduct.setLabel(RandomStringUtils.randomAlphanumeric(5));
        finalProductRepository.save(finalProduct);
    }

    public List<FinalProductionProcess> getAllForPeriodWithSteps(Date from, Date to) {
        List<FinalProductionProcess> retWithSteps = new ArrayList<>();
        Calendar calFrom = Calendar.getInstance();
        calFrom.setTime(from);
        Calendar calTo = Calendar.getInstance();
        calTo.setTime(to);
        for (FinalProductionProcess fp : finalProductionProcessRepository.findAll()) {
            Calendar processDate = Calendar.getInstance();
            processDate.setTime(fp.getDateStart());
            if (processDate.getTime().after(calFrom.getTime()) && processDate.getTime().before(calTo.getTime())) {
                retWithSteps.add(finalProductionProcessRepository.processWithFinalSteps(fp.getId()));
            }
        }
        return retWithSteps;
    }

    public List<FinalProductionProcess> getFinalProcesses() {
        return this.finalProductionProcessRepository.findAll();
    }
}
