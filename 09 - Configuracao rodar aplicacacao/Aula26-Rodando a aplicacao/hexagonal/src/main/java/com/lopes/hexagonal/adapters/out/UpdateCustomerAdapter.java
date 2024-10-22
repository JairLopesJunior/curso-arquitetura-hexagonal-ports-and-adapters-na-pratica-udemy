package com.lopes.hexagonal.adapters.out;

import com.lopes.hexagonal.adapters.out.repository.CustomerRepository;
import com.lopes.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import com.lopes.hexagonal.application.core.domain.Customer;
import com.lopes.hexagonal.application.ports.out.UpdateCustomerOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateCustomerAdapter implements UpdateCustomerOutputPort {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerEntityMapper customerEntityMapper;

    @Override
    public void update(Customer customer) {
        var customerEntity = this.customerEntityMapper.toCustomerEntity(customer);
        customerRepository.save(customerEntity);
    }
}
