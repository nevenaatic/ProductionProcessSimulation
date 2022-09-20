package com.example.demo.service.others;

import com.example.demo.model.productionProcess.ProductionProcess;
import com.example.demo.service.productionProcess.ProductionProcessService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StatisticService {


    private ProductionProcessService productionProcessService;

    public StatisticService(ProductionProcessService productionProcessService) {
        this.productionProcessService = productionProcessService;
    }

    public List<String> getProcessNames(){
        List<String> processNames = new ArrayList<>();
        for(ProductionProcess p: productionProcessService.getAllProcess()){
                processNames.add(p.getName());
        }
        return processNames;
    }
}
