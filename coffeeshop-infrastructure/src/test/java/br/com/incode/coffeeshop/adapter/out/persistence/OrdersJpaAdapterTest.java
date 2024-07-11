package br.com.incode.coffeeshop.adapter.out.persistence;

import br.com.incode.coffeeshop.application.order.LineItem;
import br.com.incode.coffeeshop.application.order.Order;
import br.com.incode.coffeeshop.application.out.OrderNotFound;
import br.com.incode.coffeeshop.application.out.Orders;
import br.com.incode.coffeeshop.shared.Drink;
import br.com.incode.coffeeshop.shared.Location;
import br.com.incode.coffeeshop.shared.Milk;
import br.com.incode.coffeeshop.shared.Size;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

@PersistenceTest
public class OrdersJpaAdapterTest {

    @Autowired
    private Orders orders;

    @Autowired
    private OrderJpaRepository orderJpaRepository;

    @Test
    void creatingOrderReturnsPersistedOrder() {
        var order = new Order(Location.TAKE_AWAY, List.of(
                new LineItem(Drink.LATTE, Milk.WHOLE, Size.SMALL, 1)
        ));

        var persistedOrder = orders.save(order);

        assertThat(persistedOrder.getLocation()).isEqualTo(Location.TAKE_AWAY);
        assertThat(persistedOrder.getItems()).containsExactly(
                new LineItem(Drink.LATTE, Milk.WHOLE, Size.SMALL, 1)
        );
    }

    @Test
    @Sql("classpath:data/order.sql")
    void findingPreviouslyPersistedOrderReturnsDetails() {
        var order = orders.findOrderById(UUID.fromString("757d9c0f-400f-4137-9aea-83e64ba3efb2"));

        assertThat(order.getLocation()).isEqualTo(Location.IN_STORE);
        assertThat(order.getItems()).containsExactly(new LineItem(Drink.ESPRESSO, Milk.SKIMMED, Size.LARGE, 1));
    }

    @Test
    void findingNonExistingOrderThrowsException() {
        assertThatThrownBy(() -> orders.findOrderById(UUID.randomUUID())).isInstanceOf(OrderNotFound.class);
    }

    @Test
    @Sql("classpath:data/order.sql")
    void deletesPreviouslyPersistedOrder() {
        orders.deleteById(UUID.fromString("757d9c0f-400f-4137-9aea-83e64ba3efb2"));

        assertThat(orderJpaRepository.findById(UUID.fromString("757d9c0f-400f-4137-9aea-83e64ba3efb2"))).isEmpty();
    }
}
