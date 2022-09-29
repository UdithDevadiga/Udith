package com.map.join.controller;

import com.map.join.modal.Customer;
import com.map.join.modal.OrderResponse;
import com.map.join.service.CustomerProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerProductController {
    @Autowired
    CustomerProductService customerProductService;
    @PostMapping("/placeOrder")
    public Customer placeOrder(@RequestBody Customer customer) {
        return customerProductService.placeOrder(customer);
    }
    @GetMapping("/viewOrders")
    public List<Customer> viewAllOrders() {
        return customerProductService.viewAllOrders();
    }
    @GetMapping("/getJoinInfo")

    public List<OrderResponse> getJoinInfo(){
        return customerProductService.getJoinInfo();
    }
}
