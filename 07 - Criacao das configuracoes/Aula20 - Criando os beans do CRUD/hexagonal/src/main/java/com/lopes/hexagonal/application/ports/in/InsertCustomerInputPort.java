package com.lopes.hexagonal.application.ports.in;

import com.lopes.hexagonal.application.core.domain.Customer;

public interface InsertCustomerInputPort {

    void insert(Customer customer, String zipCode);
}
