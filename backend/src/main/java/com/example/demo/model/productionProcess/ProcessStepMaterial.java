package com.example.demo.model.productionProcess;

import com.example.demo.enums.MaterialType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.io.Serializable;

@Entity
@IdClass(ProcessStepMaterialId.class)
public class ProcessStepMaterial{

    @Id
    private int material_id;
    @Id
    private int processStep_id;

    @Column(nullable = false)
    private MaterialType materialType;

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

    public MaterialType getMaterialType() {
        return materialType;
    }

    public void setMaterialType(MaterialType materialType) {
        this.materialType = materialType;
    }
}
