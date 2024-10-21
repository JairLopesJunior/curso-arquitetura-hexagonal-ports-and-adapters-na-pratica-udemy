package com.lopes.hexagonal.application.ports.in;

import com.lopes.hexagonal.application.core.domain.Customer;

public interface FindCustomerByIdInputPort {

    Customer find(String id);
}
