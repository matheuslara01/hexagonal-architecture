package br.com.incode.coffeeshop.adapter.in.rest;

import br.com.incode.coffeeshop.application.out.Orders;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static br.com.incode.application.order.OrderTestFactory.anOrder;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RestResourceTest
public class PaymentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private Orders orders;

    @Test
    void payOrder() throws Exception {
        var order = orders.save(anOrder());

        mockMvc.perform(put("/payment/{id}", order.getId())
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content("""
                            {
                                "cardHolderName": "Michael",
                                "cardNumber": "12369874654987965",
                                "expiryMonth": 12,
                                "expiryYear": 2035
                            }
                        """))
                .andExpect(status().isOk());
    }
}
