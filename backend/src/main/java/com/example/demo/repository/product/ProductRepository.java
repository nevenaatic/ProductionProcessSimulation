package com.example.demo.repository.product;

import com.example.demo.model.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    Product findById(int id);

    @Query("select p from Product p left join fetch p.productionProcessList pp where p.id =?1")
    Product productWithProcesses(int id);
}
