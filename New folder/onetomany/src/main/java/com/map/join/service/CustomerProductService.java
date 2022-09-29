package com.map.join.service;

import com.map.join.modal.Customer;
import com.map.join.modal.OrderResponse;
import com.map.join.modal.Product;
import com.map.join.repository.CustomerRepository;
import com.map.join.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerProductService {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ProductRepository productRepository;

    public Customer placeOrder(Customer customer) {
        return customerRepository.save(customer);
    }

    public List<Customer> viewAllOrders() {
        return customerRepository.findAll();
    }

    public List<OrderResponse> getJoinInfo() {
        return customerRepository.getJoinInfo();
    }

}
