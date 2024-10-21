package com.lopes.hexagonal.application.ports.out;

import com.lopes.hexagonal.application.core.domain.Address;

public interface FindAddressByZipCodeOutputPort {

    Address find(String zipCode);
}
