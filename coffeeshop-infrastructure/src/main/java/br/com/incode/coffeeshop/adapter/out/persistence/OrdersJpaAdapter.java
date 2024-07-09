package br.com.incode.coffeeshop.adapter.out.persistence;

import br.com.incode.coffeeshop.adapter.out.persistence.entity.OrderEntity;
import br.com.incode.coffeeshop.application.order.Order;
import br.com.incode.coffeeshop.application.out.OrderNotFound;
import br.com.incode.coffeeshop.application.out.Orders;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class OrdersJpaAdapter implements Orders {

    private final OrderJpaRepository orderJpaRepository;

    @Override
    public Order findOrderById(UUID orderId) throws OrderNotFound {
        return orderJpaRepository.findById(orderId)
                .map(OrderEntity::toDomain)
                .orElseThrow(OrderNotFound::new);
    }

    @Override
    public Order save(Order order) {
        return orderJpaRepository.save(OrderEntity.fromDomain(order)).toDomain();
    }

    @Override
    public void deleteById(UUID orderId) {
        orderJpaRepository.deleteById(orderId);
    }
}
