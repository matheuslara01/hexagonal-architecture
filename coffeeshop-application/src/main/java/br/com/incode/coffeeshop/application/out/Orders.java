package br.com.incode.coffeeshop.application.out;

import br.com.incode.coffeeshop.application.order.Order;

import java.util.UUID;

public interface Orders {
    Order findOrderById(UUID orderId) throws OrderNotFound;
    Order save(Order order);
    void deleteById(UUID orderId);
}
