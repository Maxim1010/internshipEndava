package org.github.java8.examples.behaviorParametrization;

public class Scoping {

    Runnable r1 = () -> { System.out.println(this); };
    Runnable r2 = () -> { System.out.println(toString()); };
    public String toString() { return "Hello, world!"; }

    public static void main(String... args) {
        Scoping runnable = new Scoping();
        new Thread(runnable.r1).start();
        new Thread(runnable.r2).start();
    }
}
