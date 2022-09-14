package com.example.demo.dto.process;

import com.example.demo.model.productionProcess.ProcessStep;
import com.example.demo.model.productionProcess.ProcessStepKind;

public class ProcessStepDto {

   public int id;
   public String name;
   public String description;
   public int numberOfPeople;

    public ProcessStepDto(ProcessStep step) {
        this.id = step.getId();
        this.name = step.getName();
        this.description = step.getDescription();
        this.numberOfPeople = step.getProcessStepKind().getNumberOfPeople();
    }
    public ProcessStepDto() {
    }

}
