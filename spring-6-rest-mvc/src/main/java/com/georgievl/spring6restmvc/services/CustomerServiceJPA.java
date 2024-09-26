package com.georgievl.spring6restmvc.services;

import com.georgievl.spring6restmvc.mappers.CustomerMapper;
import com.georgievl.spring6restmvc.model.CustomerDTO;
import com.georgievl.spring6restmvc.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerServiceJPA implements CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Override
    public CustomerDTO saveNewCustomer(CustomerDTO customerDTO) {
        return customerMapper
                .customerToCustomerDTO(customerRepository
                        .save(customerMapper.customerDtoToCustomer(customerDTO)));
    }
}
