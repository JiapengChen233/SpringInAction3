package com.cjp.pizza.service;

import com.cjp.pizza.exception.CustomerNotFoundException;
import com.cjp.pizza.domain.Customer;

public interface CustomerService {
    Customer lookupCustomer(String phoneNumber) throws CustomerNotFoundException;
}