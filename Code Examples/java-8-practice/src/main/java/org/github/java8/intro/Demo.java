package org.github.java8.intro;

import org.github.java8.intro.example.base.CreditCard;
import org.github.java8.intro.example.v1.BasicShop;
import org.github.java8.intro.example.v2.EnhancedShop;
import org.github.java8.intro.example.v3.SuperEnhancedShop;

public class Demo {

    static void demoV1(CreditCard creditCard) {
        System.out.println(BasicShop.buyDonut(creditCard));
    }

    static void demoV2(CreditCard creditCard) {
        System.out.println(EnhancedShop.buyDonut(creditCard));
    }

    static void demoV3(CreditCard creditCard) {
        System.out.println(SuperEnhancedShop.buyDonuts(4, creditCard));
    }


    public static void main(String... xs) {
        CreditCard creditCard = new CreditCard(999, "1234-ABCD");
        demoV1(creditCard);
        demoV2(creditCard);
        demoV3(creditCard);
    }
}
