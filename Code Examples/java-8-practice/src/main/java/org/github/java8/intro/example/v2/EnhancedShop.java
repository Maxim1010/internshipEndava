package org.github.java8.intro.example.v2;

import org.github.java8.intro.example.base.CreditCard;
import org.github.java8.intro.example.base.Donut;
import org.github.java8.intro.example.base.Tuple;

public class EnhancedShop {

    //Better
    public static Tuple<Donut, Payment> buyDonut(CreditCard creditCard) {
        return new Tuple<>(new Donut(), new Payment(creditCard, Donut.price));
    }
}
