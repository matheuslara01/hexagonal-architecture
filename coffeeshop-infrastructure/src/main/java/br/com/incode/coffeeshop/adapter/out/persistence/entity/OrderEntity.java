package br.com.incode.coffeeshop.adapter.out.persistence.entity;

import br.com.incode.coffeeshop.application.order.Order;
import br.com.incode.coffeeshop.shared.Location;
import br.com.incode.coffeeshop.shared.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Entity
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderEntity {

    @Id
    private UUID id;

    @Enumerated
    @NotNull
    private Location location;

    @Enumerated
    @NotNull
    private Status status;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "ORDER_ID")
    private List<LineItemEntity> items;

    public Order toDomain() {
        return new Order(
                id,
                location,
                items.stream().map(LineItemEntity::toDomain).toList(),
                status
        );
    }

    public static OrderEntity fromDomain(Order order) {
        return OrderEntity.builder()
                .id(order.getId())
                .location(order.getLocation())
                .status(order.getStatus())
                .items(order.getItems().stream().map(LineItemEntity::fromDomain).toList())
                .build();
    }
}
