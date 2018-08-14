package org.github.java8.examples.lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class ThreadSafety {

    private static Runnable length(final List<String> list) {
        return () -> {
            System.out.println(list.size());
            list.remove(0);
        };
    }

    public static void main(String... xs) {
        List<String> list = new ArrayList<>(Arrays.asList("1", "2", "33","dkefns"));

        for(int i = 0; i < 10; i++) {
            new Thread(length(list)).run();
        }
    }
}
