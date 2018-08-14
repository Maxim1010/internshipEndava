package org.github.java8.intro.example.v2;

import org.github.java8.intro.example.base.CreditCard;

public class Payment {

    public final CreditCard creditCard;
    public final int amount;

    public Payment(CreditCard creditCard, int amount) {
        this.creditCard = creditCard;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Credit Card=" + creditCard +", amount=" + amount;
    }
}