package com.example.demo.dto.engagements;

import com.example.demo.enums.StatusOfWork;
import com.example.demo.model.failure.Failure;

public class EngagementsStepsDto {

    public int id;
    public String processStepName;
    public boolean failed;
    public double hours;
    public StatusOfWork status;

    public EngagementsStepsDto(int id, String processStepName, boolean failed,double hours, StatusOfWork status) {
        this.id = id;
        this.processStepName = processStepName;
        this.failed = failed;
        this.hours = hours;
        this.status = status;
    }
}
