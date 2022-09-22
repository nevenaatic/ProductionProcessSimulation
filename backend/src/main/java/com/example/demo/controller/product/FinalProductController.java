package com.example.demo.controller.product;

import com.example.demo.dto.products.FinalProductDto;
import com.example.demo.model.product.FinalProduct;
import com.example.demo.model.users.User;
import com.example.demo.service.product.FinalProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "finalProduct")
public class FinalProductController {

    private FinalProductService productService;

    public FinalProductController(FinalProductService productService) {
        this.productService = productService;
    }

    @GetMapping("unchecked")
    public ResponseEntity<List<FinalProductDto>> getUnchecked(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User)authentication.getPrincipal();
        List<FinalProductDto> ret = new ArrayList<>();
        for(FinalProduct f: this.productService.getUncheckedProducts()){
            ret.add(new FinalProductDto(f.getId(), f.getLabel(), f.getProductForFinal().getName(), f.getProductType(), f.isChecked()));
        }
        return  new ResponseEntity<>(ret, HttpStatus.OK);
    }

    @GetMapping("scrap")
    public ResponseEntity<List<FinalProductDto>> getScraps(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User)authentication.getPrincipal();
        List<FinalProductDto> ret = new ArrayList<>();
        for(FinalProduct f: this.productService.getScrapChecked()){
            ret.add(new FinalProductDto(f.getId(), f.getLabel(), f.getProductForFinal().getName(), f.getProductType(), f.isChecked()));
        }
        return  new ResponseEntity<>(ret, HttpStatus.OK);
    }

    @GetMapping("regular")
    public ResponseEntity<List<FinalProductDto>> getRegular(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User)authentication.getPrincipal();
        List<FinalProductDto> ret = new ArrayList<>();
        for(FinalProduct f: this.productService.getRegularChecked()){
            ret.add(new FinalProductDto(f.getId(), f.getLabel(), f.getProductForFinal().getName(), f.getProductType(), f.isChecked()));
        }
        return  new ResponseEntity<>(ret, HttpStatus.OK);
    }

    @PostMapping("check")
    public ResponseEntity<HttpStatus> checkFinalProduct(@RequestBody int id){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User)authentication.getPrincipal();
        this.productService.checkProduct(id, user);
        return  new ResponseEntity<>( HttpStatus.OK);
    }
}
