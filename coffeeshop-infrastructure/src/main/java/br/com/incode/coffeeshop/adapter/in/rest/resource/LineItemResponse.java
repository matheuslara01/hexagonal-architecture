package br.com.incode.coffeeshop.adapter.in.rest.resource;

import br.com.incode.coffeeshop.application.order.LineItem;
import br.com.incode.coffeeshop.shared.Drink;
import br.com.incode.coffeeshop.shared.Milk;
import br.com.incode.coffeeshop.shared.Size;

public record LineItemResponse(Drink drink, Milk milk, Size size, Integer quantity) {
    public static LineItemResponse fromDomain(LineItem lineItem) {
        return new LineItemResponse(
                lineItem.drink(),
                lineItem.milk(),
                lineItem.size(),
                lineItem.quantity()
        );
    }
}
