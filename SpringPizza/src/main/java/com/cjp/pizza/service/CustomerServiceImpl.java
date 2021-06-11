package com.cjp.pizza.service;

import com.cjp.pizza.exception.CustomerNotFoundException;
import com.cjp.pizza.domain.Customer;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
    public CustomerServiceImpl() {
    }

    public Customer lookupCustomer(String phoneNumber) throws CustomerNotFoundException {
        Customer result;
        if ("9725551234".equals(phoneNumber)) {
            Customer customer = new Customer();
            customer.setId(123);
            customer.setName("Craig Walls");
            customer.setAddress("3700 Dunlavy Rd");
            customer.setCity("Denton");
            customer.setState("TX");
            customer.setZipCode("76210");
            customer.setPhoneNumber(phoneNumber);
            result = customer;
        } else {
            throw new CustomerNotFoundException();
        }
        return result;
    }
}
