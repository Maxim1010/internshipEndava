package org.github.java8.examples.functionalInterface.annotation;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class RandomSequence implements SequenceGenerator<Double> {
    @Override
    public List<Double> generateSequence(int count) {
        List<Double> result = new ArrayList<>();
        for(int i = 0; i < count; i++) {
            result.add(getRandomDouble());
        }
        return result;
    }

    public Double[] generateArraySequence(int count) {
        List<Double> sequence = generateSequence(count);
        return sequence.toArray(new Double[sequence.size()]);
    }

    private double getRandomDouble() {
        return ThreadLocalRandom.current().nextDouble();
    }
}
