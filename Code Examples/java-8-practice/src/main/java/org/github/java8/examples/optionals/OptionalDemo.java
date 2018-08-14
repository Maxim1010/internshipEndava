package org.github.java8.examples.optionals;

import javax.xml.ws.Provider;
import java.util.Optional;
import java.util.function.Function;

public class OptionalDemo {

    public static void main(String... xs) throws InterruptedException {
        Optional<String> o1 = Optional.of("Hello World");
        System.out.println(o1.map(s -> null));
        Thread.sleep(2 * 1000);
        System.out.println(o1.flatMap(s -> null));
    }

    static <T> Optional<T> toOptional(T t) {
        return Optional.ofNullable(t);
    }
}
