package org.github.java8.intro.example.v3;


import org.github.java8.intro.example.base.CreditCard;

public class Payment {

    public final CreditCard creditCard;
    public final int amount;

    public Payment(CreditCard creditCard, int amount) {
        this.creditCard = creditCard;
        this.amount = amount;
    }

    public Payment combine(Payment payment) {
        if (creditCard.equals(payment.creditCard)) {
            return new Payment(creditCard, amount + payment.amount);
        } else {
            throw new IllegalStateException("Cards don't match.");
        }
    }

    @Override
    public String toString() {
        return "Credit Card=" + creditCard +", amount=" + amount;
    }
}
