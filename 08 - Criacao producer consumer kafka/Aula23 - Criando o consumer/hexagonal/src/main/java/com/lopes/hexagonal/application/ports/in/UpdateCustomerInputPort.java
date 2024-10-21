package com.lopes.hexagonal.application.ports.in;

import com.lopes.hexagonal.application.core.domain.Customer;

public interface UpdateCustomerInputPort {

    void update(Customer customer, String zipCode);
}
