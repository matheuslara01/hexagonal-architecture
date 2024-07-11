package br.com.incode.coffeeshop.adapter.in.rest;

import br.com.incode.coffeeshop.application.out.Orders;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static br.com.incode.application.order.OrderTestFactory.anOrder;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RestResourceTest
public class OrderControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private Orders orders;

    private final String orderJson = """
                {
                    "location": "IN_STORE",
                    "items": [{
                        "drink": "LATTE",
                        "quantity": 1,
                        "milk": "WHOLE",
                        "size": "LARGE"
                    }]
                }
            """;
    @Test
    void createOrder() throws Exception {
        mockMvc.perform(post("/order")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(orderJson))
                .andExpect(status().isCreated());
    }

    @Test
    void updateOrder() throws Exception {
        var order = orders.save(anOrder());

        mockMvc.perform(patch("/order/{id}", order.getId())
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(orderJson))
                .andExpect(status().isOk());
    }

    @Test
    void cancelOrder() throws Exception {
        var order = orders.save(anOrder());

        mockMvc.perform(delete("/order/{id}", order.getId()))
                .andExpect(status().isNoContent());
    }


}
