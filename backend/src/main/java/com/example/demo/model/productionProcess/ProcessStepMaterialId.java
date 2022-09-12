package com.example.demo.model.productionProcess;

import java.io.Serializable;

public class ProcessStepMaterialId implements Serializable {
    private int material_id;
    private int processStep_id;

    public int getMaterial_id() {
        return material_id;
    }

    public void setMaterial_id(int material_id) {
        this.material_id = material_id;
    }

    public int getProcessStep_id() {
        return processStep_id;
    }

    public void setProcessStep_id(int processStep_id) {
        this.processStep_id = processStep_id;
    }
}
