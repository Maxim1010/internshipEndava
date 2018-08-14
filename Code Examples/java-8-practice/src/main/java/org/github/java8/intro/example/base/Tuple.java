package org.github.java8.intro.example.base;

public class Tuple<K, V> {

    public final K key;
    public final V value;

    public Tuple(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return "key:" + key + " value=" + value;
    }
}
