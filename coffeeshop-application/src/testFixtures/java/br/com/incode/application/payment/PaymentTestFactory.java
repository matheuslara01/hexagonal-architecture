package br.com.incode.application.payment;

import br.com.incode.coffeeshop.application.order.Order;
import br.com.incode.coffeeshop.application.payment.Payment;

import java.time.LocalDate;

import static br.com.incode.application.payment.CreditCardTestFactory.aCreditCard;

public class PaymentTestFactory {

    public static Payment aPaymentForOrder(Order order) {
        return new Payment(
                order.getId(),
                aCreditCard(),
                LocalDate.now()
        );
    }
}
