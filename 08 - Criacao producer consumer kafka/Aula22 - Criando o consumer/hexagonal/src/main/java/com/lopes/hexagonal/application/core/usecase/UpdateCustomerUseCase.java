package com.lopes.hexagonal.application.core.usecase;

import com.lopes.hexagonal.application.core.domain.Customer;
import com.lopes.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.lopes.hexagonal.application.ports.in.UpdateCustomerInputPort;
import com.lopes.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import com.lopes.hexagonal.application.ports.out.UpdateCustomerOutputPort;

public class UpdateCustomerUseCase implements UpdateCustomerInputPort {

    private final FindCustomerByIdInputPort findCustomerByIdInputPort;

    private final FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort;

    private final UpdateCustomerOutputPort updateCustomerOutputPort;

    public UpdateCustomerUseCase(FindCustomerByIdInputPort findCustomerByIdInputPort,
                                 FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort,
                                 UpdateCustomerOutputPort updateCustomerOutputPort) {
        this.findCustomerByIdInputPort = findCustomerByIdInputPort;
        this.findAddressByZipCodeOutputPort = findAddressByZipCodeOutputPort;
        this.updateCustomerOutputPort = updateCustomerOutputPort;
    }

    @Override
    public void update(Customer customer, String zipCode) {
        this.findCustomerByIdInputPort.find(customer.getId());
        var address = this.findAddressByZipCodeOutputPort.find(zipCode);
        customer.setAddress(address);
        this.updateCustomerOutputPort.update(customer);
    }
}




















