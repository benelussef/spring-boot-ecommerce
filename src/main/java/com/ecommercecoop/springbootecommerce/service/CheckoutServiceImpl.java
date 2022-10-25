package com.ecommercecoop.springbootecommerce.service;


import com.ecommercecoop.springbootecommerce.dao.CustomerRepository;
import com.ecommercecoop.springbootecommerce.dto.Purchase;
import com.ecommercecoop.springbootecommerce.dto.PurchaseResponse;
import com.ecommercecoop.springbootecommerce.entity.Customer;
import com.ecommercecoop.springbootecommerce.entity.Order;
import com.ecommercecoop.springbootecommerce.entity.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Set;
import java.util.UUID;


@Service
public class CheckoutServiceImpl implements CheckoutService {

    private CustomerRepository customerRepository;

    @Autowired
    public CheckoutServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {

        Order order = purchase.getOrder();


        String orderTrackingNumber = generateOrderTrackingNumber();
        order.setOrderTrackingNumber(orderTrackingNumber);


        Set<OrderItem> orderItems = purchase.getOrderItems();
        orderItems.forEach(item -> order.add(item));


        order.setBillingAddress(purchase.getBillingAddress());
        order.setShippingAddress(purchase.getShippingAddress());


        Customer customer = purchase.getCustomer();
        String email = customer.getEmail();
        Customer customer1 = customerRepository.findByEmail(email);
        if(customer1 != null) {
            customer = customer1;
        }
        customer.add(order);


        customerRepository.save(customer);


        return new PurchaseResponse(orderTrackingNumber);
    }

    private String generateOrderTrackingNumber() {
        return UUID.randomUUID().toString();
    }
}









