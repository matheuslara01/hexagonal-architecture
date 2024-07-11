package br.com.incode.application.payment;

import br.com.incode.coffeeshop.application.payment.CreditCard;

import java.time.Month;
import java.time.Year;

public class CreditCardTestFactory {
    public static CreditCard aCreditCard() {
        return new CreditCard("Joseph", "45641325489645684", Month.JANUARY, Year.of(2035));
    }

}
