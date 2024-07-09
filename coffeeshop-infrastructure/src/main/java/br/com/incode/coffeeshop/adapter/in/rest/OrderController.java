package br.com.incode.coffeeshop.adapter.in.rest;

import br.com.incode.coffeeshop.adapter.in.rest.resource.OrderRequest;
import br.com.incode.coffeeshop.adapter.in.rest.resource.OrderResponse;
import br.com.incode.coffeeshop.application.in.OrderingCoffee;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class OrderController {

    private final OrderingCoffee orderingCoffee;

    @PostMapping("/order")
    ResponseEntity<OrderResponse> createOrder(@RequestBody OrderRequest request, UriComponentsBuilder uriComponentsBuilder) {
        var order = orderingCoffee.placeOrder(request.toDomain());
        var location = uriComponentsBuilder.path("/order/{id}")
                .buildAndExpand(order.getId())
                .toUri();

        return ResponseEntity.created(location).body(OrderResponse.fromDomain(order));
    }

    @PatchMapping("/order/{id}")
    ResponseEntity<OrderResponse> updateOrder(@PathVariable UUID id, @RequestBody OrderRequest request) {
        var order = orderingCoffee.updateOrder(id, request.toDomain());
        return ResponseEntity.ok(OrderResponse.fromDomain(order));
    }

    @DeleteMapping("/order/{id}")
    ResponseEntity<Void> cancelOrder(@PathVariable UUID id) {
        orderingCoffee.cancelOrder(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/order/{id}")
    ResponseEntity<OrderResponse> getOrder(@PathVariable UUID id) {
        var order = orderingCoffee.getOrder(id);
        return ResponseEntity.ok(OrderResponse.fromDomain(order));
    }

}
