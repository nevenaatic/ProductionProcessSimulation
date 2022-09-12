package com.example.demo.service.product;

import com.example.demo.model.product.FinalProduct;
import com.example.demo.model.product.Product;
import com.example.demo.model.productionProcess.ProductionProcess;
import com.example.demo.repository.product.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product getById(int id) {
        return productRepository.findById(id);
    }

    public List<Product> getAll() {
        return productRepository.findAll();
    }

    public Product addProcessForProduct(int id, ProductionProcess process) {
        Product product = productWithProcesses(id);
        product.getProductionProcessList().add(process);
        return productRepository.save(product);
    }

    public Product addFinalProduct(int id, FinalProduct fProduct) {
        Product product = getById(id); //IZMENI NA QUERY
        product.getFinalProductList().add(fProduct);
        return productRepository.save(product);
    }

    public Product productWithProcesses(int id){
        return productRepository.productWithProcesses(id);
    }
}
