package br.com.incode.coffeeshop.application;

import br.com.incode.architeture.UseCase;
import br.com.incode.coffeeshop.application.in.PreparingCoffee;
import br.com.incode.coffeeshop.application.order.Order;
import br.com.incode.coffeeshop.application.out.Orders;

import java.util.UUID;

@UseCase
public class CoffeeMachine implements PreparingCoffee {

    private final Orders orders;
    public CoffeeMachine(Orders orders) {
        this.orders = orders;
    }
    @Override
    public Order startPreparingOrder(UUID orderId) {
        var order = orders.findOrderById(orderId);

        return orders.save(order.markBeingPrepared());
    }

    @Override
    public Order finishPreparingOrder(UUID orderId) {
        var order = orders.findOrderById(orderId);

        return orders.save(order.markPrepared());
    }
}
