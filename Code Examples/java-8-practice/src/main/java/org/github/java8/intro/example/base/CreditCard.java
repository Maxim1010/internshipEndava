package org.github.java8.intro.example.base;


public class CreditCard {
    private int total;
    private String cardNumber;

    public CreditCard(int total, String cardNumber) {
        this.total = total;
        this.cardNumber = cardNumber;
    }

    public void charge(int price) {
        // TODO: connect to payment service
    }

    public int getTotal() {
        return total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CreditCard that = (CreditCard) o;

        if (total != that.total) return false;
        return cardNumber.equals(that.cardNumber);
    }

    @Override
    public int hashCode() {
        int result = total;
        result = 31 * result + cardNumber.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "total=" + total + " cardNumber='" + cardNumber;
    }
}
