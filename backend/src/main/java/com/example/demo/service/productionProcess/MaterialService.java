package com.example.demo.service.productionProcess;

import com.example.demo.dto.process.MaterialDto;
import com.example.demo.model.others.Material;
import com.example.demo.repository.productionProcess.MaterialRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MaterialService {

    private MaterialRepository materialRepository;

    public MaterialService(MaterialRepository materialRepository){
        this.materialRepository = materialRepository;
    }

    public List<Material> getMaterialForStep(int id){
        return materialRepository.getMaterialForSteps(id);
    }

    public List<MaterialDto> getMaterialsForStep(int id){
        List<MaterialDto> materials = new ArrayList<>();
        for(Material m: getMaterialForStep(id)){
            materials.add(new MaterialDto(m));
        }
        return materials;
    }
}
