package com.lopes.hexagonal.adapters.out;

import com.lopes.hexagonal.adapters.out.client.FindAddressByZipCodeClient;
import com.lopes.hexagonal.adapters.out.client.mapper.AddressResponseMapper;
import com.lopes.hexagonal.application.core.domain.Address;
import com.lopes.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FindAddressByZipCodeAdapter implements FindAddressByZipCodeOutputPort {

    @Autowired
    private FindAddressByZipCodeClient findAddressByZipCodeClient;

    @Autowired
    private AddressResponseMapper addressResponseMapper;

    @Override
    public Address find(String zipCode) {
        var addressResponse = this.findAddressByZipCodeClient.find(zipCode);
        return this.addressResponseMapper.toAdress(addressResponse);
    }
}



























