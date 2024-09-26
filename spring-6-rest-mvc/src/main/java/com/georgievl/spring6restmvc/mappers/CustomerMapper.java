package com.georgievl.spring6restmvc.mappers;

import com.georgievl.spring6restmvc.entities.Customer;
import com.georgievl.spring6restmvc.model.CustomerDTO;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerMapper {
    Customer customerDtoToCustomer(CustomerDTO customerDTO);
    CustomerDTO customerToCustomerDTO(Customer customer);
}
