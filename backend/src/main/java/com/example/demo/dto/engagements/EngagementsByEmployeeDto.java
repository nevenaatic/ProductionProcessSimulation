package com.example.demo.dto.engagements;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EngagementsByEmployeeDto {

    public String processName;
    public String processLabel;
    public Date dateStart;
    public Date dateEnd;
    public List<EngagementsStepsDto> engagementsStepsDtoList = new ArrayList<>();
    public boolean failed;


    public EngagementsByEmployeeDto() {
    }

    public EngagementsByEmployeeDto(String processName, String processLabel, Date dateStart, Date dateEnd, List<EngagementsStepsDto> engagementsStepsDtoList, boolean failed) {
        this.processName = processName;
        this.processLabel = processLabel;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.engagementsStepsDtoList = engagementsStepsDtoList;
        this.failed = failed;
    }


}
