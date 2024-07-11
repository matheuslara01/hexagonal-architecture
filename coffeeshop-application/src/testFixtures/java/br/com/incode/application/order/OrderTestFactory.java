package br.com.incode.application.order;

import br.com.incode.coffeeshop.application.order.LineItem;
import br.com.incode.coffeeshop.application.order.Order;
import br.com.incode.coffeeshop.shared.Drink;
import br.com.incode.coffeeshop.shared.Location;
import br.com.incode.coffeeshop.shared.Milk;
import br.com.incode.coffeeshop.shared.Size;

import java.util.List;

public class OrderTestFactory {

    public static Order anOrder() {
        return new Order(Location.TAKE_AWAY, List.of(
                new LineItem(Drink.LATTE, Milk.WHOLE, Size.LARGE, 1)
        ));
    }

    public static Order aPaidOrder() {
        return anOrder().markPaid();
    }

    public static Order anOrderInPreparation() {
        return aPaidOrder().markBeingPrepared();
    }

    public static Order aReadyOrder() {
        return anOrderInPreparation().markPrepared();
    }
}
