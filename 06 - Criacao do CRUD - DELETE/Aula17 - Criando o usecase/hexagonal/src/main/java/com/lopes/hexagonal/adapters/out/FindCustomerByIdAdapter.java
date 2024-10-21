package com.lopes.hexagonal.adapters.out;

import com.lopes.hexagonal.adapters.out.repository.CustomerRepository;
import com.lopes.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import com.lopes.hexagonal.application.core.domain.Customer;
import com.lopes.hexagonal.application.ports.out.FindCustomerByIdOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FindCustomerByIdAdapter implements FindCustomerByIdOutputPort {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerEntityMapper customerEntityMapper;

    @Override
    public Optional<Customer> find(String id) {
        var customerEntity = this.customerRepository.findById(id);
        return customerEntity.map(entity -> this.customerEntityMapper.toCustomer(entity));
    }
}























