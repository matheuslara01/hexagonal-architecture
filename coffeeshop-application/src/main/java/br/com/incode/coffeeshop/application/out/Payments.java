package br.com.incode.coffeeshop.application.out;

import br.com.incode.coffeeshop.application.payment.Payment;

import java.util.UUID;

public interface Payments {

    Payment findPaymentByOrderId(UUID orderId);
    Payment save(Payment payment);
}
