package com.cjp.pizza.service;

import com.cjp.pizza.domain.Order;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl {
    private static final Logger LOGGER = Logger.getLogger(OrderServiceImpl.class);

    public OrderServiceImpl() {
    }

    public void saveOrder(Order order) {
        LOGGER.debug("SAVING ORDER:  ");
        LOGGER.debug("   Customer:  " + order.getCustomer().getName());
        LOGGER.debug("   # of Pizzas:  " + order.getPizzas().size());
        LOGGER.debug("   Payment:  " + order.getPayment());
    }
}
