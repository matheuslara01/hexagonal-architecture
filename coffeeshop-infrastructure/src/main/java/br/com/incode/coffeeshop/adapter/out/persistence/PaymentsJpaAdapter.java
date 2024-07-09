package br.com.incode.coffeeshop.adapter.out.persistence;

import br.com.incode.coffeeshop.adapter.out.persistence.entity.PaymentEntity;
import br.com.incode.coffeeshop.application.out.Payments;
import br.com.incode.coffeeshop.application.payment.Payment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class PaymentsJpaAdapter implements Payments {

    private final PaymentJpaRepository paymentJpaRepository;


    @Override
    public Payment findPaymentByOrderId(UUID orderId) {
        return paymentJpaRepository.findByOrderId(orderId)
                .map(PaymentEntity::toDomain)
                .orElseThrow();
    }

    @Override
    public Payment save(Payment payment) {
        return paymentJpaRepository.save(PaymentEntity.fromDomain(payment)).toDomain();
    }
}
