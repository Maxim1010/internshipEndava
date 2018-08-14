package org.github.java8.examples.optionals;

import java.util.Optional;

public class OptionalUtil {

    public static Optional<Integer> parseString(String s) {
        try {
            return Optional.of(Integer.valueOf(s));
        } catch (NumberFormatException nfe) {
            return Optional.empty();
        }
    }
}
