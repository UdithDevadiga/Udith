package com.robosoft.jpa.repository;

import com.robosoft.jpa.modal.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {

    Product findByName(String name);

}
