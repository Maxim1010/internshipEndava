package org.github.java8.examples.behaviorParametrization;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class BPDishDemo {

    private class Dessert extends Dish {

        public Dessert(String name, boolean vegetarian, int calories,
                Type type) {
            super(name, vegetarian, calories, type);
        }

        @Override
        public boolean isVegetarian() {
            return true;
        }
    }

    public static List<Dish> getMenu() {
        return Arrays.asList(new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 400, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH));
    }

    private Predicate<Dish> dishPredicate = (Dish dish) -> {
        Dish.Type dishType = dish.getType();
        return dishType.equals(Dish.Type.OTHER);
    };

    public static void main(String... xs) {
        print(filterVegeratian(getMenu()));
        print(filterByCalories(getMenu(), 300));
        Predicate<Dish> isVegerarian = new Predicate<Dish>() {
            @Override
            public boolean test(Dish dish) {
                return dish.isVegetarian();
            }
        };

        print(genericFilter(getMenu(),isVegerarian));
        Predicate<Dish> lowCaloryMeals = dish -> dish.getCalories() < 300;
        print(genericFilter(getMenu(), lowCaloryMeals));
        print(genericFilter(getMenu(), lowCaloryMeals.and(isVegerarian)));



    }


    public static List<Dish> filterVegeratian(List<Dish> menu) {
        List<Dish> result = new ArrayList<>();
        for(Dish dish: menu) {
            if(dish.isVegetarian()) {
                result.add(dish);
            }
        }
        return result;
    }

    public static List<Dish> genericFilter(List<Dish> menu, Predicate<Dish> predicate) {
        List<Dish> result = new ArrayList<>();
        for(Dish dish: menu) {
            if(predicate.test(dish)) {
                result.add(dish);
            }
        }
        return result;
    }

    public static List<Dish> filterByCalories(List<Dish> menu, int threshold) {
        List<Dish> result = new ArrayList<>();
        for(Dish dish: menu) {
            if(dish.getCalories() < threshold) {
                result.add(dish);
            }
        }
        return result;
    }

    public static void print(List<Dish> menu) {
        menu.forEach(System.out::println);
        System.out.println("====");
    }
}
