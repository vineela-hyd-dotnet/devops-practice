package com.ProductPract.ProductPract.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ProductPract.ProductPract.model.Product;

public interface ProdRepo  extends JpaRepository<Product,Integer>{

}
