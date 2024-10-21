package com.lopes.hexagonal.application.core.usecase;

import com.lopes.hexagonal.application.core.domain.Customer;
import com.lopes.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.lopes.hexagonal.application.ports.out.FindCustomerByIdOutputPort;

public class FindCustomerByIdUseCase implements FindCustomerByIdInputPort {

    private final FindCustomerByIdOutputPort findCustomerByIdOutputPort;

    public FindCustomerByIdUseCase(FindCustomerByIdOutputPort findCustomerByIdOutputPort) {
        this.findCustomerByIdOutputPort = findCustomerByIdOutputPort;
    }

    @Override
    public Customer find(String id) {
        return this.findCustomerByIdOutputPort.find(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
    }
}































