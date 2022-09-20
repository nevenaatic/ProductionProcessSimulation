package com.example.demo.repository.product;

import com.example.demo.model.product.FinalProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FinalProductRepository extends JpaRepository<FinalProduct, Integer> {

    @Query("select fp from FinalProduct fp where fp.productType = 1 and fp.checked = true")
    List<FinalProduct> getScrapsChecked();

    @Query("select fp from FinalProduct fp where fp.productType = 0 and fp.checked = true")
    List<FinalProduct> getRegularChecked();

    @Query("select fp from FinalProduct fp where fp.checked = false")
    List<FinalProduct> getUnchecked();

    FinalProduct findById(int id);
}
