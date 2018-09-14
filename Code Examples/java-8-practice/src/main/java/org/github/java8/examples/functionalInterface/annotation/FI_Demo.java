package org.github.java8.examples.functionalInterface.annotation;

import java.util.List;

public class FI_Demo {

    public static void main(String... xs) {
        SequenceGenerator<Double> rs = new RandomSequence();
        rs.test();
        print(rs.generateSequence(10));

        SequenceGenerator<Integer> fiboSeq = new FibonacciSequence();
        fiboSeq.test();
        print(fiboSeq.generateSequence(10));
    }

    private static <T> void print(List<T> xs) {
        xs.forEach(x -> System.out.print(x + " "));
        System.out.println();
    }
}
