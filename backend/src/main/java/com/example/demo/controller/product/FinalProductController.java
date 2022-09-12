package com.example.demo.controller.product;

import com.example.demo.service.product.FinalProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "finalProduct")
public class FinalProductController {

    private FinalProductService productService;

    public FinalProductController(FinalProductService productService) {
        this.productService = productService;
    }
}
