package org.github.java8.examples.behaviorParametrization;

import java.util.Optional;

public class Dish {

    public enum Type { MEAT, FISH, OTHER }

    private Optional<String> name;
    private final boolean vegetarian;
    private final int calories;
    private final Type type;

    public Dish(String name, boolean vegetarian, int calories, Type type) {
        this.name = Optional.ofNullable(name);
        this.vegetarian = vegetarian;
        this.calories = calories;
        this.type = type;
    }

    public void setName(String name) {
        this.name = Optional.ofNullable(name);
    }

    public Optional<String> getName() {
        return name;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public int getCalories() {
        return calories;
    }

    public Type getType() {
        return type;
    }

}
