package com.map.join.repository;

import com.map.join.modal.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product , Integer> {
}
