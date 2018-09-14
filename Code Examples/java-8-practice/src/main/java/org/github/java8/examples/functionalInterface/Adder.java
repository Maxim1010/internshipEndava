package org.github.java8.examples.functionalInterface;

@FunctionalInterface
public interface Adder {
    public int add(int a, int b);
}

interface DoubleAdder extends Adder {
    //public int add(double a, double b);

    public static void main(String... xs) {
        DoubleAdder adder = (int  a, int b) -> a + b;
        int c = adder.add(2, 3);
        System.out.println(c);

    }
}

