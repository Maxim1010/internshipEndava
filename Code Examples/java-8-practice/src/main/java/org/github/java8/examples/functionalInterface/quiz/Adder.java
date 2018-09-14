package org.github.java8.examples.functionalInterface.quiz;

interface Adder {
    public int add(int a, int b);
}

// This is not a functional interface
interface SmartAdder extends Adder {
    public int add(double a, double b);
}

class ExperimentInheritance {
    Adder adder = (a, b) -> a + b;
    //SmartAdder adder1 = (Integer a, Integer b) -> a + b;
}

