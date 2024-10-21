package com.lopes.hexagonal.adapters.out;

import com.lopes.hexagonal.adapters.out.repository.CustomerRepository;
import com.lopes.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import com.lopes.hexagonal.application.core.domain.Customer;
import com.lopes.hexagonal.application.ports.out.InsertCustomerOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class insertCustomerAdapter implements InsertCustomerOutputPort {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerEntityMapper customerEntityMapper;

    @Override
    public void insert(Customer customer) {
        var customerEntity = this.customerEntityMapper.toCustomerEntity(customer);
        this.customerRepository.save(customerEntity);
    }
}





























