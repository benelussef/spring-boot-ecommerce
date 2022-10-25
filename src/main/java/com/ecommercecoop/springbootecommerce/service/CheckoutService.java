package com.ecommercecoop.springbootecommerce.service;

import com.ecommercecoop.springbootecommerce.dto.Purchase;
import com.ecommercecoop.springbootecommerce.dto.PurchaseResponse;


public interface CheckoutService {

    PurchaseResponse placeOrder(Purchase purchase);
}
