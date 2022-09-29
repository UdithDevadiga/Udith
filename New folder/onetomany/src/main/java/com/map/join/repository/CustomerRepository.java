package com.map.join.repository;

import com.map.join.modal.Customer;
import com.map.join.modal.OrderResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer , Integer> {
    @Query("select new com.map.join.modal.OrderResponse(c.name,p.pName) from Customer c Join c.products p")
    public List<OrderResponse> getJoinInfo();
}
