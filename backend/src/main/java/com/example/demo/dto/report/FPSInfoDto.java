package com.example.demo.dto.report;

import java.util.ArrayList;
import java.util.List;

public class FPSInfoDto {

    public String processStepName;
    public double duration;
    public boolean isValid;
    public String failure;
    public double materialPrice;
    public List<EmployeeWithHoursDto> employees = new ArrayList<>();
}
