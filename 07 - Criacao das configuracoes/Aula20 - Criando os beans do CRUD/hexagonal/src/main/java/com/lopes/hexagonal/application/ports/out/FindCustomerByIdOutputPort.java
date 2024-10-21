package com.lopes.hexagonal.application.ports.out;

import com.lopes.hexagonal.application.core.domain.Customer;

import java.util.Optional;

public interface FindCustomerByIdOutputPort {

    Optional<Customer> find(String id);
}
