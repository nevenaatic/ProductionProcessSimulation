package com.example.demo.service.product;

import com.example.demo.repository.product.FinalProductRepository;
import org.springframework.stereotype.Service;

@Service
public class FinalProductService {

    private FinalProductRepository finalProductRepository;

    public FinalProductService(FinalProductRepository finalProductRepository) {
        this.finalProductRepository = finalProductRepository;
    }
}
