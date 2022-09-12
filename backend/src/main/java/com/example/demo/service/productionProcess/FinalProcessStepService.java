package com.example.demo.service.productionProcess;

import com.example.demo.repository.product.FinalProductRepository;
import org.springframework.stereotype.Service;

@Service
public class FinalProcessStepService {

    private FinalProductRepository finalProductRepository;

    public FinalProcessStepService(FinalProductRepository finalProductRepository) {
        this.finalProductRepository = finalProductRepository;
    }
}
