package org.github.java8.examples.capture;

import java.util.function.Function;

public class CaptorDemo {

    public static Runnable noCapture() {
        return () -> System.out.println("Hello World");
    }

    public static Runnable captureArgument(String name) {
        return () -> System.out.println("Hello " + name);
    }

    public static Runnable captureVariable() {
        int magicNumber = 42;
        return () -> System.out.println("The answer to life, the universe and everything: " + magicNumber);
    }

    public static Function<Integer, Integer> finalCapture() {
        int n = 0;
        return arg -> {
            System.out.print(n + " " + arg + ": ");
            arg += 1;
            // n += arg;
            return n + arg;
        };
    }

    public static void main(String... xs) {

    }
}
