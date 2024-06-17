package com.wrkspot.assignment.service;

import com.wrkspot.assignment.dao.Customer;
import com.wrkspot.assignment.repository.CustomerRepository;
import com.wrkspot.assignment.util.FilterUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public List<Customer> getCustomers(final Map<String, String> filter) {
        if (filter.isEmpty()) {
            return this.customerRepository.findAll();
        } else {
            return this.customerRepository.findAll(FilterUtils.buildSpecification(filter));
        }
    }

    @Override
    @Transactional
    public Customer createCustomer(final Customer customer) {
        final Customer customerSaved = this.customerRepository.save(customer);
//        this.kafkaTemplate.send("customer-topic", "Customer created: " + customerSaved.getId());
        return customerSaved;
    }

}
