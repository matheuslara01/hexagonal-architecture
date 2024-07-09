package br.com.incode.coffeeshop.adapter.in.rest.resource;

import br.com.incode.coffeeshop.application.order.LineItem;
import br.com.incode.coffeeshop.application.order.Order;
import br.com.incode.coffeeshop.shared.Location;

import java.math.BigDecimal;
import java.util.List;

public record OrderResponse(Location location, List<LineItemResponse> items, BigDecimal cost) {
    public static OrderResponse fromDomain(Order order) {
        return new OrderResponse(
                order.getLocation(),
                order.getItems().stream().map(LineItemResponse::fromDomain).toList(),
                order.getCost()
        );
    }
}
