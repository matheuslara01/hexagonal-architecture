package br.com.incode.coffeeshop.adapter.in.rest.resource;

import br.com.incode.coffeeshop.application.order.LineItem;
import br.com.incode.coffeeshop.shared.Drink;
import br.com.incode.coffeeshop.shared.Milk;
import br.com.incode.coffeeshop.shared.Size;

public record LineItemRequest(Drink drink, Milk milk, Size size, Integer quantity) {
    public LineItem toDomain() {
        return new LineItem(drink, milk, size, quantity);
    }
}
