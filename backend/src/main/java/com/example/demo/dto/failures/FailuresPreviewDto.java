package com.example.demo.dto.failures;

import com.example.demo.enums.FailureType;
import com.example.demo.model.failure.Failure;

public class FailuresPreviewDto {

    public int id;
    public String name;
    public FailureType type;
    public double probability;
    public String steps;

    public FailuresPreviewDto() {
    }
    public FailuresPreviewDto(Failure failure, String steps) {
        this.id = failure.getId();
        this.type = failure.getFailureType();
        this.name = failure.getName();
        this.probability = failure.getProbability();
        this.steps = steps;
    }
}
