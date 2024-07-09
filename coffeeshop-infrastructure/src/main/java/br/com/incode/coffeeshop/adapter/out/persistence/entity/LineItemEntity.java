package br.com.incode.coffeeshop.adapter.out.persistence.entity;

import br.com.incode.coffeeshop.application.order.LineItem;
import br.com.incode.coffeeshop.shared.Drink;
import br.com.incode.coffeeshop.shared.Milk;
import br.com.incode.coffeeshop.shared.Size;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LineItemEntity {

    @Id
    @GeneratedValue
    private UUID id;

    @Enumerated
    @NotNull
    private Drink drink;

    @Enumerated
    @NotNull
    private Size size;

    @Enumerated
    @NotNull
    private Milk milk;

    @NotNull
    private Integer quantity;

    public LineItem toDomain() {
        return new LineItem(
                drink,
                milk,
                size,
                quantity
        );
    }

    public static LineItemEntity fromDomain(LineItem lineItem) {
        return LineItemEntity.builder()
                .drink(lineItem.drink())
                .size(lineItem.size())
                .milk(lineItem.milk())
                .quantity(lineItem.quantity())
                .build();
    }
}
