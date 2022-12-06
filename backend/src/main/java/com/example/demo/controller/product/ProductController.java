package com.example.demo.controller.product;

import com.example.demo.dto.products.ProductDto;
import com.example.demo.model.product.Product;
import com.example.demo.service.product.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "products")
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value="/")
    @PreAuthorize("hasAnyRole('PRODUCTION_MANAGER', 'PROCESS_ENGINEER')")
    public ResponseEntity<List<ProductDto>> getAll() {
        List<ProductDto> products = new ArrayList<>();
        for (Product p : this.productService.getAll()) {
            products.add(new ProductDto(p));
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @PostMapping(value="/")
    @PreAuthorize("hasAnyRole('PRODUCTION_MANAGER')")
    public ResponseEntity<HttpStatus> saveProduct(@RequestBody ProductDto productDto) {
        productService.saveProduct(new Product( productDto.finalPrice,productDto.description,productDto.name));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping(value="/{id}")
    @PreAuthorize("hasAnyRole('PRODUCTION_MANAGER')")
    public ResponseEntity<HttpStatus> saveProduct(@PathVariable int id) {
        productService.deleteById(id);
           return new ResponseEntity<>(HttpStatus.OK);
    }
}
