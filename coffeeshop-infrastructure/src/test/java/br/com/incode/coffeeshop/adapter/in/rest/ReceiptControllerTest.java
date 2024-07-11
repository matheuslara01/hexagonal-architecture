package br.com.incode.coffeeshop.adapter.in.rest;

import br.com.incode.coffeeshop.application.out.Orders;
import br.com.incode.coffeeshop.application.out.Payments;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import static br.com.incode.application.order.OrderTestFactory.aReadyOrder;
import static br.com.incode.application.order.OrderTestFactory.anOrder;
import static br.com.incode.application.payment.PaymentTestFactory.aPaymentForOrder;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RestResourceTest
public class ReceiptControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private Orders orders;

    @Autowired
    private Payments payments;

    @Test
    void readReceipt() throws Exception {
        var order = orders.save(anOrder());
        payments.save(aPaymentForOrder(order));

        mockMvc.perform(get("/receipt/{id}", order.getId()))
                .andExpect(status().isOk());
    }

    @Test
    void completeOrder() throws Exception {
        var order = orders.save(aReadyOrder());

        mockMvc.perform(delete("/receipt/{id}", order.getId()))
                .andExpect(status().isOk());
    }
}
