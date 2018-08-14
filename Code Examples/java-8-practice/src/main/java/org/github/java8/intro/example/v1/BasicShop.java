package org.github.java8.intro.example.v1;


import org.github.java8.intro.example.base.CreditCard;
import org.github.java8.intro.example.base.Donut;

public class BasicShop {

    /**
     * FIXME: Bakes a new donut and charges me: too many concerns
     */
    public static Donut buyDonut(CreditCard creditCard) {
        Donut donut = new Donut();
        //FIXME: credit card contains all the logic for the payment
        //FIXME: Do I know how much have I paid for this?
        creditCard.charge(Donut.price);
        return donut;
    }
}
