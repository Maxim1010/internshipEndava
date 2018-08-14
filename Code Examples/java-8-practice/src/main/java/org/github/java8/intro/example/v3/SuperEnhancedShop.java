package org.github.java8.intro.example.v3;

import org.github.java8.intro.example.base.CreditCard;
import org.github.java8.intro.example.base.Donut;
import org.github.java8.intro.example.base.Tuple;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SuperEnhancedShop {

    public static Tuple<Donut, Payment> buyDonut(CreditCard cc) {
        return new Tuple<>(new Donut(), new Payment(cc, Donut.price));
    }

    public static Tuple<List<Donut>, Payment> buyDonuts(int n, CreditCard creditCard) {
        List<Donut> donuts = Stream.generate(Donut::new).limit(n).collect(Collectors.toList());
        return new Tuple<>(donuts, new Payment(creditCard, Donut.price * n));
    }
}