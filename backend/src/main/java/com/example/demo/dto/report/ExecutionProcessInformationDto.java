package com.example.demo.dto.report;

import com.example.demo.dto.report.FPSInfoDto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ExecutionProcessInformationDto {

    public String name;
    public String label;
    public Date date;
    public boolean isValid;
    public double materialMoney;
    public String processEngineer;
    public double duration;
    public String productName;
    public double productPrice;
    public String dateString;
    public List<FPSInfoDto> finalProcessInfo = new ArrayList<>();

}
