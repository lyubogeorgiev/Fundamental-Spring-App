package com.georgievl.spring6restmvc.services;

import com.georgievl.spring6restmvc.model.CustomerDTO;

public interface CustomerService {
    CustomerDTO saveNewCustomer(CustomerDTO customerDTO);
}
