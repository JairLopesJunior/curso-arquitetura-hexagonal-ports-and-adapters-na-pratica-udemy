package com.lopes.hexagonal.adapters.out.client.mapper;

import com.lopes.hexagonal.adapters.out.client.response.AddressResponse;
import com.lopes.hexagonal.application.core.domain.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressResponseMapper {

    Address toAdress(AddressResponse addressResponse);
}
