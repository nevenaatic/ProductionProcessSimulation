package com.example.demo.dto.process;

import com.example.demo.model.productionProcess.FinalProductionProcess;

import java.util.Date;

public class FinalProductionProcessDto {

    public int id;
    public String label;
    public String name;
    public Date start;
    public double duration;
    public boolean isValid;

    public FinalProductionProcessDto() {
    }

    public FinalProductionProcessDto(FinalProductionProcess process, double duration) {
        this.id = process.getId();
        this.label = process.getLabel();
        this.name = process.getProductionProcess().getName();
        this.start = process.getDateStart();
        this.isValid = true;
        this.duration = duration;
    }
}
