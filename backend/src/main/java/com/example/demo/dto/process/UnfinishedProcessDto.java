package com.example.demo.dto.process;

import java.util.List;

public class UnfinishedProcessDto {

    public int id;
    public String name;
    public String description;
    public List<ProcessStepDto> steps;
    public String productName;

    public UnfinishedProcessDto(int id, String name, String description, List<ProcessStepDto> steps, String productName) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.steps = steps;
        this.productName = productName;
    }

    public UnfinishedProcessDto() {
    }


}
