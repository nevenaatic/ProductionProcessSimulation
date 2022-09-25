package com.example.demo.service.productionProcess;

import com.example.demo.dto.process.NewProcessForCreateDto;
import com.example.demo.dto.process.NewProcessStepDto;
import com.example.demo.dto.process.ProcessStepDto;
import com.example.demo.dto.process.UnfinishedProcessDto;
import com.example.demo.model.product.Product;
import com.example.demo.model.productionProcess.ProcessStep;
import com.example.demo.model.productionProcess.ProcessStepKind;
import com.example.demo.model.productionProcess.ProductionProcess;
import com.example.demo.model.productionProcess.StepOfProductionProcess;
import com.example.demo.model.users.ProcessEngineer;
import com.example.demo.model.users.User;
import com.example.demo.repository.productionProcess.ProductionProcessRepository;
import com.example.demo.service.product.ProductService;
import com.example.demo.service.users.ProcessEngineerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductionProcessService {

    private ProductionProcessRepository productionProcessRepository;
    private ProductService productService;
    private ProcessStepService processStepService;
    private ProcessStepKindService processStepKindService;
    private StepOfProductionProcessService stepOfPPService;
    private ProcessEngineerService processEngineerService;
    private MaterialService materialService;

    public ProductionProcessService(ProductionProcessRepository productionProcessRepository,
                                    ProductService productService, ProcessStepService processStep,
                                    ProcessStepKindService processStepKindService, StepOfProductionProcessService stepOfPPService,
                                    ProcessEngineerService engineer, MaterialService materialService) {
        this.productionProcessRepository = productionProcessRepository;
        this.productService = productService;
        this.processStepService = processStep;
        this.processStepKindService = processStepKindService;
        this.stepOfPPService = stepOfPPService;
        this.processEngineerService = engineer;
        this.materialService = materialService;
    }

    public List<ProductionProcess> getAllProcess(){
        return productionProcessRepository.findAll();
    }

    public ProductionProcess getById(int id){
        return  productionProcessRepository.findById(id);
    }
    //this can be written in ProcessStepService
    public List<ProcessStep> getStepsForProductionProcess(int id){
        ProductionProcess process = productionProcessRepository.processWithSteps(id);
        List<ProcessStep> processSteps = new ArrayList<>();
        for (StepOfProductionProcess s: process.getStepOfPPList()) {
            processSteps.add(processStepService.findStep(s.getProcessStep().getId()));
        }
        return processSteps;
    }

    public ProductionProcess getProcessWithFinalList(int id){
        return this.productionProcessRepository.processWithFinalProcesses(id);
    }

    public ResponseEntity<HttpStatus> createProcess(NewProcessForCreateDto newProcess, User engineer) {
        ProductionProcess productionProcess = new ProductionProcess();
        productionProcess.setName(newProcess.name);
        productionProcess.setDescription(newProcess.description);
        List<ProcessStep> steps = new ArrayList<>();
        ProcessEngineer processEngineer = this.processEngineerService.engineerWithProcessList(engineer.getId());
        productionProcess.setProcessEngineer(processEngineer);
        Product product = productService.productWithProcesses(newProcess.productId);
        productionProcess.setProduct(product);
        productionProcess.setFinished(false);

        for (NewProcessStepDto p : newProcess.processSteps) {
            ProcessStepKind processStepKind = processStepKindService.getById(p.idStepKind);
            steps.add(processStepService.save(new ProcessStep(p.name, p.description, processStepKind, null)));
        }

        ProductionProcess savedProcess = productionProcessRepository.save(productionProcess);

        if (savedProcess != null) {
            int num = 0;
            for (ProcessStep ps : steps) {
                stepOfPPService.save(new StepOfProductionProcess(savedProcess, ps, ++num));
            }
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    //without FinalProductionProcess setter
    private void updateProcess(ProductionProcess savedProcess) {
        ProductionProcess process = productionProcessRepository.getById(savedProcess.getId());
        process.setProduct(savedProcess.getProduct());
        process.setDescription(savedProcess.getDescription());
        process.setProcessEngineer(savedProcess.getProcessEngineer());
        process.setName(savedProcess.getName());
        productionProcessRepository.save(process);
    }

    public List<UnfinishedProcessDto> getAllWithSteps() {
        List<ProductionProcess> processes = this.productionProcessRepository.findAll();
        List<UnfinishedProcessDto> ret = new ArrayList<>();
        for (ProductionProcess p : processes) {
            // ProductionProcess pp = productionProcessRepository.processWithSteps(p.getId());
            List<ProcessStepDto> steps = new ArrayList<>();
            List<StepOfProductionProcess> stepOfPP = this.stepOfPPService.findStepsForProcess(p.getId());
            for (StepOfProductionProcess s : stepOfPP) {
                ProcessStep ps = processStepService.findStep(s.getProcessStep().getId());
                ProcessStepDto stepDto = new ProcessStepDto(ps);
                stepDto.materials = materialService.getMaterialsForStep(ps.getId());
                steps.add(stepDto);
            }
                UnfinishedProcessDto unfinishedProcessDto = new UnfinishedProcessDto(p.getId(), p.getName(), p.getDescription(), steps, p.getProduct().getName());
                ret.add(unfinishedProcessDto);
        }
        return ret;
    }

    public UnfinishedProcessDto getProcessWithSteps(int id){
        UnfinishedProcessDto ret = new UnfinishedProcessDto();
        for(UnfinishedProcessDto up: getAllWithSteps()){
            if(up.id == id){
                ret = up;
            }
        }
        return ret;
    }

    public void save(ProductionProcess process) {
        productionProcessRepository.save(process);
    }
}
