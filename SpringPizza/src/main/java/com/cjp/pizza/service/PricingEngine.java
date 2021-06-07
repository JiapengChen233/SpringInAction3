package com.cjp.pizza.service;

import com.cjp.pizza.domain.Order;

public interface PricingEngine {
    float calculateOrderTotal(Order order);
}
