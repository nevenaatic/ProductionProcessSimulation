package com.example.demo.dto.process;

import com.example.demo.model.productionProcess.ProcessStepKind;

public class ProcessStepKindPreviewDto {

    public String name;
    public int numberOfPeople;
    public int id;

    public ProcessStepKindPreviewDto(String name, int numberOfPeople, int id) {
        this.name = name;
        this.numberOfPeople = numberOfPeople;
        this.id= id;
    }

    public ProcessStepKindPreviewDto(ProcessStepKind processStepKind){
        this.name = processStepKind.getName();
        this.numberOfPeople = processStepKind.getNumberOfPeople();
        this.id = processStepKind.getId();
    }
}
