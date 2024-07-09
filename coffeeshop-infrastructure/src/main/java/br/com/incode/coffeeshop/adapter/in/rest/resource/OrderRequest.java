package br.com.incode.coffeeshop.adapter.in.rest.resource;

import br.com.incode.coffeeshop.application.order.Order;
import br.com.incode.coffeeshop.shared.Location;
import org.aspectj.weaver.ast.Or;

import java.util.List;

public record OrderRequest(Location location, List<LineItemRequest> items) {
    public Order toDomain() {
        return new Order(location, items.stream().map(LineItemRequest::toDomain).toList());
    }
}
