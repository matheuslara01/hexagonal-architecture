package br.com.incode.coffeeshop.adapter.out.persistence;

import br.com.incode.coffeeshop.adapter.out.persistence.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrderJpaRepository extends JpaRepository<OrderEntity, UUID> {
}
