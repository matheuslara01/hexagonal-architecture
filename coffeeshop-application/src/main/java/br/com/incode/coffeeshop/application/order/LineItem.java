package br.com.incode.coffeeshop.application.order;

import br.com.incode.coffeeshop.shared.Drink;
import br.com.incode.coffeeshop.shared.Milk;
import br.com.incode.coffeeshop.shared.Size;

import java.math.BigDecimal;

public record LineItem(Drink drink, Milk milk, Size size, int quantity) {

    BigDecimal getCost() {
        var price = BigDecimal.valueOf(4.0);
        if (size == Size.LARGE)
            price = price.add(BigDecimal.ONE);

        return price.multiply(BigDecimal.valueOf(quantity));
    }
}
