package com.wrkspot.assignment.rest;

import com.wrkspot.assignment.dao.Customer;
import com.wrkspot.assignment.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public List<Customer> getCustomers(final @RequestParam Map<String, String> filter) {
        return customerService.getCustomers(filter);
    }

    @PostMapping
    public Customer createCustomer(final @RequestBody Customer customer) {
        return customerService.createCustomer(customer);
    }
}