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

    public List<Product> getAll() {
        return productRepository.findAll();
    }

    public Product addProcessForProduct(int id, ProductionProcess process) {
        Product product = productWithProcesses(id);
        product.getProductionProcessList().add(process);
        return productRepository.save(product);
    }

    public void saveProduct(Product product){
        productRepository.save(product);
    }

    public void deleteById(int idProduct){
        productRepository.deleteById(idProduct);
    }

    public Product findProductForProcess(int idProcess){
        return productRepository.findProductForProcess(idProcess);
    }

    public Product productWithProcesses(int id){
        return productRepository.productWithProcesses(id);
    }
}
