package com.lopes.hexagonal.adapters.out;

import com.lopes.hexagonal.adapters.out.repository.CustomerRepository;
import com.lopes.hexagonal.application.ports.out.DeleteCustomerByIdOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteCustomerByIdAdapter implements DeleteCustomerByIdOutputPort {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void delete(String id) {
        this.customerRepository.deleteById(id);
    }
}
