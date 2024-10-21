package com.lopes.hexagonal.adapters.in.controller;

import com.lopes.hexagonal.adapters.in.controller.mapper.CustomerMapper;
import com.lopes.hexagonal.adapters.in.controller.request.CustomerRequest;
import com.lopes.hexagonal.adapters.in.controller.response.CustomerResponse;
import com.lopes.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.lopes.hexagonal.application.ports.in.InsertCustomerInputPort;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    @Autowired
    private InsertCustomerInputPort insertCustomerInputPort;

    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private FindCustomerByIdInputPort findCustomerByIdInputPort;

    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody CustomerRequest request) {
        var customer = this.customerMapper.toCustomer(request);
        this.insertCustomerInputPort.insert(customer, request.getZipCode());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> findById(@PathVariable final String id) {
        var customer = this.findCustomerByIdInputPort.find(id);
        var customerResponse = this.customerMapper.toCustomerResponse(customer);
        return ResponseEntity.ok().body(customerResponse);
    }
}


















































