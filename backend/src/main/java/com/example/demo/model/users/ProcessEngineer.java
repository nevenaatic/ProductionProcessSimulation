package com.example.demo.model.users;

import com.example.demo.model.product.FinalProduct;
import com.example.demo.model.productionProcess.FinalProductionProcess;
import com.example.demo.model.productionProcess.ProductionProcess;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@DiscriminatorColumn(name = "PE")
public class ProcessEngineer extends User{

    @OneToMany(mappedBy = "processEngineer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnoreProperties("processEngineer")
    private List<ProductionProcess> productionProcessList;

    @OneToMany(mappedBy = "processEngineer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnoreProperties("processEngineer")
    private List<FinalProductionProcess> finalProductionProcessList;

    public List<ProductionProcess> getProductionProcessList() {
        return productionProcessList;
    }

    public void setProductionProcessList(List<ProductionProcess> productionProcessList) {
        this.productionProcessList = productionProcessList;
    }
}
