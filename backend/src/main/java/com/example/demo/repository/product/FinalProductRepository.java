package com.example.demo.repository.product;

import com.example.demo.model.product.FinalProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FinalProductRepository extends JpaRepository<FinalProduct, Integer> {
}
