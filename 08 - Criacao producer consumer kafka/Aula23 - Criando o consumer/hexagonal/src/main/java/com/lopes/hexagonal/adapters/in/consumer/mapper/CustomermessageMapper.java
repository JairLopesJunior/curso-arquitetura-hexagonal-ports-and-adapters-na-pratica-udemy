package com.lopes.hexagonal.adapters.in.consumer.mapper;

import com.lopes.hexagonal.adapters.in.consumer.message.CustomerMessage;
import com.lopes.hexagonal.application.core.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomermessageMapper {

    @Mapping(target = "address", ignore = true)
    Customer toCustomer(CustomerMessage customerMessage);
}
