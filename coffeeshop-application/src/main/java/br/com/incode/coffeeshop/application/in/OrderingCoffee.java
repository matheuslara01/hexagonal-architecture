package br.com.incode.coffeeshop.application.in;

import br.com.incode.coffeeshop.application.order.Order;
import br.com.incode.coffeeshop.application.payment.CreditCard;
import br.com.incode.coffeeshop.application.payment.Payment;
import br.com.incode.coffeeshop.application.payment.Receipt;

import java.util.UUID;

public interface OrderingCoffee {
    Order placeOrder(Order order);
    Order updateOrder(UUID orderId, Order order);
    void cancelOrder(UUID orderId);
    Payment payOrder(UUID orderId, CreditCard creditCard);
    Receipt readReceipt(UUID orderId);
    Order takeOrder(UUID orderId);
}
