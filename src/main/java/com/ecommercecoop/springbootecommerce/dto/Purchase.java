package com.ecommercecoop.springbootecommerce.dto;

import com.ecommercecoop.springbootecommerce.entity.Address;
import com.ecommercecoop.springbootecommerce.entity.Customer;
import com.ecommercecoop.springbootecommerce.entity.Order;
import com.ecommercecoop.springbootecommerce.entity.OrderItem;
import lombok.Data;

import java.util.Set;

@Data
public class Purchase {

    private Customer customer;
    private Address shippingAddress;
    private Address billingAddress;
    private Order order;
    private Set<OrderItem> orderItems;

}
