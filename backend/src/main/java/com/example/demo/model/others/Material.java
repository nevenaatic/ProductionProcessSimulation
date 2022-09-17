package com.example.demo.model.others;

import com.example.demo.enums.MaterialUnits;
import com.example.demo.model.productionProcess.ProcessStep;

import javax.persistence.*;
import java.util.List;

@Entity
public class Material {

    @Id
    @SequenceGenerator(name = "materialSeqGen", sequenceName = "materialSeqGen", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "materialSeqGen")
    @Column(name = "id")
    private int id;

    @Column(unique = true)
    private String label_id;
    @Column(nullable = false)
    private double price;
    @Column(nullable = false)
    private String name;
    @Column(nullable = true)
    private MaterialUnits materialUnitType;

    @ManyToMany
    @JoinTable(
            name = "step_material",
            joinColumns = @JoinColumn(name = "material_id"),
            inverseJoinColumns = @JoinColumn(name = "step_id"))
    private List<ProcessStep> processSteps;

    public List<ProcessStep> getProcessSteps() {
        return processSteps;
    }

    public void setProcessSteps(List<ProcessStep> processSteps) {
        this.processSteps = processSteps;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLabel_id() {
        return label_id;
    }

    public void setLabel_id(String label_id) {
        this.label_id = label_id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MaterialUnits getMaterialUnitType() {
        return materialUnitType;
    }

    public void setMaterialUnitType(MaterialUnits materialUnitType) {
        this.materialUnitType = materialUnitType;
    }
}
