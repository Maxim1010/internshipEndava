package org.github.java8.examples.functionalInterface.annotation;

import java.util.ArrayList;
import java.util.List;

public class FibonacciSequence implements SequenceGenerator<Integer> {
    @Override
    public List<Integer> generateSequence(int count) {
        List<Integer> result = new ArrayList<>();
        result.add(1);
        result.add(1);
        for(int i = 2; i < count; i++) {
            int tmp = result.get(i - 1) + result.get(i - 2);
            result.add(tmp);
        }
        return result;
    }

    @Override
    public void test() {
        System.out.println("Hello form fibo");
    }
}
