package org.example;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.function.BiFunction;
import java.util.function.Function;

public class MyArrayBasedList<T> implements MyList<T>{

    private T[] myArray;
    private int size = 0;

    public MyArrayBasedList (int length){
        myArray = (T[]) new Object[length];
    }


    public static <T> MyArrayBasedList<T> of(T... values) {
        MyArrayBasedList<T> result = new MyArrayBasedList<>(values.length);

        for (T value : values) {
            result.append(value);
        }

        return result;
    }

    @Override
    public MyList<T> append(T value) {
        this.myArray[this.size++] = value;
        return this;
    }

    @Override
    public T first() {
        return this.myArray[0];
    }

    @Override
    public T last() {
        return this.myArray[this.size];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public MyList<T> rest() {
        return null;
    }

    @Override
    public MyList<T> push(T value) {
        return null;
    }

    @Override
    public <V> MyList<V> map(Function<T, V> mapper) {
        return null;
    }

    @Override
    public <V> V reduce(V initialValue, BiFunction<V, T, V> accumulator) {
        return null;
    }

    @Override
    public boolean all(Function<T, Boolean> predicate) {
        return false;
    }

    @Override
    public boolean allEquals() {
        return false;
    }

    @Override
    public boolean any(Function<T, Boolean> predicate) {
        return false;
    }
}
