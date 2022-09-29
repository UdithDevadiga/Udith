package com.robosoft.onetoone.repository;

import com.robosoft.onetoone.modal.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaptopRepository extends JpaRepository<Laptop,Long> {
}
