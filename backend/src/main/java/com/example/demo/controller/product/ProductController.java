package com.example.demo.controller.product;

import com.example.demo.dto.ProductDto;
import com.example.demo.dto.process.NewProcessForCreateDto;
import com.example.demo.model.product.Product;
import com.example.demo.service.product.ProductService;
import com.example.demo.service.productionProcess.ProcessStepService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "product")
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping(value="products")
    public ResponseEntity<List<ProductDto>> getAll() {

        List<ProductDto> products = new ArrayList<>();
        for (Product p : this.productService.getAll()) {
            products.add(new ProductDto(p));
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @PostMapping(value="product")
    public ResponseEntity<HttpStatus> saveProduct(@RequestBody ProductDto productDto) {
        productService.saveProduct(new Product( productDto.finalPrice,productDto.description,productDto.name));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping(value="delete/{id}")
    public ResponseEntity<HttpStatus> saveProduct(@PathVariable int id) {
        productService.deleteById(id);
           return new ResponseEntity<>(HttpStatus.OK);

    }
}
