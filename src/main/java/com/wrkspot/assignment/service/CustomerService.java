package com.wrkspot.assignment.service;

import com.wrkspot.assignment.dao.Customer;

import java.util.List;
import java.util.Map;

public interface CustomerService {

    List<Customer> getCustomers(Map<String, String> filter);

    Customer createCustomer(Customer customer);

}
