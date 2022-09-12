package com.example.demo.service.productionProcess;

import com.example.demo.dto.process.NewProcessForCreateDto;
import com.example.demo.dto.process.NewProcessStepDto;
import com.example.demo.model.product.Product;
import com.example.demo.model.productionProcess.ProcessStep;
import com.example.demo.model.productionProcess.ProcessStepKind;
import com.example.demo.model.productionProcess.ProductionProcess;
import com.example.demo.model.users.ProcessEngineer;
import com.example.demo.model.users.User;
import com.example.demo.repository.productionProcess.ProductionProcessRepository;
import com.example.demo.service.product.ProductService;
import com.example.demo.service.users.ProcessEngineerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
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


    public ProductionProcessService(ProductionProcessRepository productionProcessRepository, ProductService productService, ProcessStepService processStep, ProcessStepKindService processStepKindService, StepOfProductionProcessService stepOfPPService, ProcessEngineerService engineer) {
        this.productionProcessRepository = productionProcessRepository;
        this.productService = productService;
        this.processStepService = processStep;
        this.processStepKindService = processStepKindService;
        this.stepOfPPService = stepOfPPService;
        this.processEngineerService = engineer;
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

        for (NewProcessStepDto p : newProcess.processSteps) {
            ProcessStepKind processStepKind = processStepKindService.getById(p.idStepKind);
            steps.add(processStepService.save(new ProcessStep(p.name, p.description, processStepKind, null)));
        }

        ProductionProcess savedProcess = productionProcessRepository.save(productionProcess);

        if(savedProcess != null){
            int num = 0;
            for ( ProcessStep ps: steps) {
                stepOfPPService.saveStepOfProductionProcess(ps.getId(), savedProcess.getId(), ++num); //OVDE PRODJE
            }
       //     productService.addProcessForProduct(newProcess.productId, savedProcess);
      //      processEngineerService.addProcessToEngineer(engineer.getId(), savedProcess);
          //  updateProcess(savedProcess);
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

}