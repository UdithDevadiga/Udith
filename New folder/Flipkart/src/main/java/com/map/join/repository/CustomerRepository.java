package com.map.join.repository;

import com.map.join.modal.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer , Integer> {
}
