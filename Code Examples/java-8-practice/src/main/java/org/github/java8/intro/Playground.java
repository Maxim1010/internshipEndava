package org.github.java8.intro;

import java.util.function.Function;

public class Playground {
    public static void main(String... xs) {
        Function<String,String> stringCons = String::new;
        System.out.print(stringCons.apply("Hello world"));
    }
}
