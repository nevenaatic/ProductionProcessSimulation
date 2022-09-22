package com.example.demo.service.productionProcess;

import com.example.demo.dto.process.FinalProductionProcessDto;
import com.example.demo.dto.process.UnfinishedProcessDto;
import com.example.demo.dto.report.EmployeeWithHoursDto;
import com.example.demo.dto.report.ExecutionProcessInformationDto;
import com.example.demo.dto.report.FPSInfoDto;
import com.example.demo.enums.ProductType;
import com.example.demo.model.failure.FailureInProcessStep;
import com.example.demo.model.others.Material;
import com.example.demo.model.product.FinalProduct;
import com.example.demo.model.productionProcess.*;
import com.example.demo.model.users.Employee;
import com.example.demo.repository.failure.FailureRepository;
import com.example.demo.repository.product.FinalProductRepository;
import com.example.demo.repository.productionProcess.EngagementsRepository;
import com.example.demo.repository.productionProcess.FinalProductionProcessRepository;
import com.example.demo.service.failure.FailureInProcessStepService;
import com.example.demo.service.pdf.PdfGeneratorService;
import com.example.demo.service.users.EmployeeService;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
    private FailureInProcessStepService failureService;
    private FailureRepository failureRepository;
    private MaterialService materialService;

    @Autowired
    private PdfGeneratorService pdfGeneratorService;

    public FinalProductionProcessService(FinalProductionProcessRepository finalProductionProcessRepository,
                                         FinalProcessStepService finalProcessStepService, ProcessStepService processStepService,
                                         ProductionProcessService productionProcessService,
                                         StepOfProductionProcessService stepOfProductionProcessService,
                                         EmployeeService employeeService, EngagementsRepository engagementsRepository,
                                         FinalProductRepository finalProductRepository, FailureInProcessStepService failureService,
                                         FailureRepository failureRepository, MaterialService materialService) {
        this.finalProductionProcessRepository = finalProductionProcessRepository;
        this.finalProcessStepService = finalProcessStepService;
        this.processStepService = processStepService;
        this.productionProcessService = productionProcessService;
        this.stepOfProductionProcessService = stepOfProductionProcessService;
        this.employeeService = employeeService;
        this.engagementsRepository = engagementsRepository;
        this.finalProductRepository = finalProductRepository;
        this.failureService = failureService;
        this.failureRepository = failureRepository;
        this.materialService = materialService;
    }

    //without failure
    public void startProcess(int id) {
        ProductionProcess process = productionProcessService.getProcessWithFinalList(id);
        List<StepOfProductionProcess> stepsOfProcess = stepOfProductionProcessService.stepsForProcessAndFinalStepList(id);
        FinalProductionProcess finalProductionProcess = new FinalProductionProcess();
        finalProductionProcess.setLabel(RandomStringUtils.randomAlphabetic(8));
        finalProductionProcess.setDateStart(new Date());
        finalProductionProcess.setValid(true);
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


    public void startFailureProcess(int id) {
        ProductionProcess process = productionProcessService.getProcessWithFinalList(id);
        List<StepOfProductionProcess> stepsOfProcess = stepOfProductionProcessService.stepsForProcessAndFinalStepList(id);
        FinalProductionProcess finalProductionProcess = new FinalProductionProcess();
        finalProductionProcess.setLabel(RandomStringUtils.randomAlphabetic(8));
        finalProductionProcess.setDateStart(new Date());
        finalProductionProcess.setValid(false);
        finalProductionProcess.setProductionProcess(process); //setovala sam nadjeni proces njemu
        finalProductionProcess = finalProductionProcessRepository.save(finalProductionProcess);  //setovala sam sad na njega samog


        Random rand = new Random();
        boolean isFailed = false;

        for (StepOfProductionProcess s : stepsOfProcess) {
            if (!isFailed) {


                FinalProcessStep finalProcessStep = new FinalProcessStep();
                finalProcessStep.setFinalProductionProcess(finalProductionProcess);
                finalProcessStep.setStepOfPP(s); //mozda treba da ga prvo sacuvam pa tek onda dodelim tom stepu
                finalProcessStep.setDateStart(new Date());
                List<FailureInProcessStep> getFailures = this.failureService.getFailureForPS(s.getProcessStep().getId()); //uzmem failure


                if (getFailures.size() > 0) {
                    int idFailure = rand.nextInt(getFailures.size() - 1) + 1;
                    FailureInProcessStep newFailure = failureService.getFailureWithFinalSteps(idFailure); //random greska
                    finalProcessStep.setFailureInPS(newFailure);
                    isFailed = true;
                }
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
        }
        FinalProduct finalProduct = new FinalProduct();
        finalProduct.setProductForFinal(process.getProduct());
        finalProduct.setChecked(false);
        finalProduct.setProductType(ProductType.SCRAP);
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

    public List<FinalProductionProcessDto> processWithFailureInformation() {
        List<FinalProductionProcessDto> ret = new ArrayList<>();
        Random rand = new Random();
        for (FinalProductionProcess p : getFinalProcesses()) {
            p = finalProductionProcessRepository.processWithFinalSteps(p.getId());  //uzmem i stepove
            double time = Math.round((10.0 + (28 - 10.0) * rand.nextDouble()) * 10.0) / 10.0;
            if (p.getValid()) {

                ret.add(new FinalProductionProcessDto(p, time, null));
            } else {
                for (FinalProcessStep s : p.getFinalProcessStepList()) {
                    if (s.getFailureInPS() != null) {
                        ret.add(new FinalProductionProcessDto(p, time, s.getFailureInPS().getFailure().getName()));
                    }
                }
            }
        }
        return ret;
    }


    public ExecutionProcessInformationDto completeInformationFromExecution(int id) {
        ExecutionProcessInformationDto ret = new ExecutionProcessInformationDto();
        FinalProductionProcess finalProductionProcess = this.finalProductionProcessRepository.processWithFinalSteps(id);
        ret.name = finalProductionProcess.getProductionProcess().getName();
        ret.label = finalProductionProcess.getLabel();
        ret.date = finalProductionProcess.getDateStart();
        ret.dateString = this.formatDate(ret.date);
        ret.isValid = finalProductionProcess.getValid();
        ret.processEngineer = "Nevena Atic";
        ret.productPrice = finalProductionProcess.getProductionProcess().getProduct().getFinalPrice();
        ret.productName = finalProductionProcess.getProductionProcess().getProduct().getName();

        for (FinalProcessStep finalProcessStep : finalProductionProcess.getFinalProcessStepList()) {
            FPSInfoDto stepInfo = new FPSInfoDto();
            FinalProcessStep step = this.finalProcessStepService.getStepWithEngagements(finalProcessStep.getId());
            stepInfo.processStepName = step.getStepOfPP().getProcessStep().getName();
            if (step.getFailureInPS() != null) {
                stepInfo.isValid = false;
                stepInfo.failure = step.getFailureInPS().getFailure().getName();
            } else {
                stepInfo.isValid = true;
            }
            //********************************
            if (materialService.getMaterialForStep(step.getId()) != null) {
                for (Material m : materialService.getMaterialForStep(step.getId())) {
                    ret.materialMoney += m.getPrice();
                }
            }
            //********************************
            double durationStep = 0;
            for (EmployeeWithEngagement e : step.getEmployeesWithEngagements()) {
                EmployeeWithHoursDto employee = new EmployeeWithHoursDto();
                employee.name = e.getEmployee().getName();
                employee.surname = e.getEmployee().getSurname();
                employee.hours = e.getHours();
                durationStep = durationMax(durationStep, employee.hours);
                stepInfo.employees.add(employee);
            }
            stepInfo.duration = durationStep;
            ret.finalProcessInfo.add(stepInfo);
        }
        this.generatePdfReport(ret);
        return ret;
    }

    private String formatDate(Date date){
        DateFormat df = new SimpleDateFormat("dd-mm-yyyy hh:mm");
        return df.format(date);
    }
    private double durationMax(double current, double next) {
        if (current < next) {
            return next;
        } else {
            return current;
        }
    }

    private void generatePdfReport(ExecutionProcessInformationDto process) {
        Map<String, Object> data = new HashMap<>();
        data.put("process", process);
        pdfGeneratorService.generatePdfFile( data, "report.pdf");
    }
}
