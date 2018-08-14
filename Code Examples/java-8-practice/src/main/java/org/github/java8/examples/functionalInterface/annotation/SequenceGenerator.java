package org.github.java8.examples.functionalInterface.annotation;

import java.util.List;

/**
 * A functional interface specifies exactly one abstract method.
 * Functional interfaces are useful because the signature of the abstract method can describe the
 * signature of a lambda expression. The signature of the abstract method of a functional interface
 * is called a function descriptor. So in order to use different lambda expressions, you need a set of
 * functional interfaces that can describe common function descriptors.
 * @param <T>
 */
@FunctionalInterface
interface SequenceGenerator<T> {
    List<T> generateSequence(int count);

    default void test() {
        System.out.println("Hello world");
    }

    default void test2() {

    }
}