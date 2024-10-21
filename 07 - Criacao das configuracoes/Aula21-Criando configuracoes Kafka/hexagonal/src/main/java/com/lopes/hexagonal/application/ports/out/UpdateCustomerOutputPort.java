package com.lopes.hexagonal.application.ports.out;

import com.lopes.hexagonal.application.core.domain.Customer;

public interface UpdateCustomerOutputPort {

    void update(Customer customer);
}
