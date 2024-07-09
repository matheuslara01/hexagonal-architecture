package br.com.incode.coffeeshop.application.in;

import br.com.incode.coffeeshop.application.order.Order;

import java.util.UUID;

public interface PreparingCoffee {

    Order startPreparingOrder(UUID orderId);
    Order finishPreparingOrder(UUID orderId);
}
