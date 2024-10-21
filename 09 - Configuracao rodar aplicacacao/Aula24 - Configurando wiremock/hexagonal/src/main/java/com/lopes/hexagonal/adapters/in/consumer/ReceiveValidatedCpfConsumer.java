package com.lopes.hexagonal.adapters.in.consumer;

import com.lopes.hexagonal.adapters.in.consumer.mapper.CustomermessageMapper;
import com.lopes.hexagonal.adapters.in.consumer.message.CustomerMessage;
import com.lopes.hexagonal.application.ports.in.UpdateCustomerInputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ReceiveValidatedCpfConsumer {

    @Autowired
    private UpdateCustomerInputPort updateCustomerInputPort;

    @Autowired
    private CustomermessageMapper customermessageMapper;

    @KafkaListener(topics = "tb-cpf-validated", groupId = "lopes")
    public void receive(CustomerMessage customerMessage) {
        var customer = this.customermessageMapper.toCustomer(customerMessage);
        this.updateCustomerInputPort.update(customer, customerMessage.getZipCode());
    }
}
