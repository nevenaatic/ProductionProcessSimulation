package com.example.demo.service.product;

import com.example.demo.model.product.FinalProduct;
import com.example.demo.model.users.QualityEngineer;
import com.example.demo.model.users.User;
import com.example.demo.repository.product.FinalProductRepository;
import com.example.demo.service.users.QualityEngineerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FinalProductService {

    private FinalProductRepository finalProductRepository;
    private QualityEngineerService engineerService;

    public FinalProductService(FinalProductRepository finalProductRepository, QualityEngineerService engineerService) {
        this.finalProductRepository = finalProductRepository;
        this.engineerService = engineerService;
    }

    public List<FinalProduct> getAll(){
        return finalProductRepository.findAll();
    }

    public List<FinalProduct> getScrapChecked(){
        return this.finalProductRepository.getScrapsChecked();
    }
    public List<FinalProduct> getRegularChecked(){
        return this.finalProductRepository.getRegularChecked();
    }
    public List<FinalProduct> getUncheckedProducts(){
        return this.finalProductRepository.getUnchecked();
    }

    public void checkProduct(int id, User user) {
        QualityEngineer engineer = engineerService.findWithProducts(user.getId());
        FinalProduct product = finalProductRepository.findById(id);
        product.setChecked(true);
        product.setQualityEngineer(engineer);
        finalProductRepository.save(product);
    }
}
