package br.com.incode.coffeeshop.config;

import br.com.incode.application.out.stub.InMemoryOrders;
import br.com.incode.application.out.stub.InMemoryPayments;
import br.com.incode.coffeeshop.application.out.Orders;
import br.com.incode.coffeeshop.application.out.Payments;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

@TestConfiguration
@Import(DomainConfig.class)
public class DomainTestConfig {

    @Bean
    Orders orders() {
        return new InMemoryOrders();
    }

    @Bean
    Payments payments() {
        return new InMemoryPayments();
    }
}
