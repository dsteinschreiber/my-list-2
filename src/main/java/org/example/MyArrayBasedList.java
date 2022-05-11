package org.example;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Function;

public class MyArrayBasedList<T extends Comparable<T>> implements MyList<T> {

    protected T[] myArray;
    protected int size = 0;

    public MyArrayBasedList(Class<T> classToken, int length) {
        myArray = (T[]) Array.newInstance(classToken, length);
    }


    public static MyArrayBasedList<Integer> of(Integer... values) {
        return of(Integer.class, values);
    }

    public static MyArrayBasedList<String> of(String... values) {
        return of(String.class, values);
    }

    public static <T extends Comparable<T>> MyArrayBasedList<T> of(Class<T> classToken, T... values) {
        MyArrayBasedList<T> result = new MyArrayBasedList<>(classToken, values.length);

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
        return this.myArray[this.size - 1];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public MyArrayBasedList sort() {
        Arrays.sort(this.myArray);
        return this;
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

    @Override
    public String toString() {
        String result = "[";

        String delimiter = "";

        for (T value : this.myArray) {
            result = result + delimiter + value;
            delimiter = ", ";
        }

        result = result + "]";

        return result;
    }

    public boolean contains(T value) {
        int start = 0;
        int end = this.size - 1;
        int mid = (start + end) / 2;

        // BINARY SEARCH
        while (start <= end) {
            if (this.myArray[mid].compareTo(value) < 0) {
                start = mid + 1;
            } else if (this.myArray[mid].compareTo(value) == 0) {
                return true;
            } else {
                end = mid - 1;
            }
            mid = (start + end) / 2;
        }
        return false;
    }

    public static <T extends Comparable <T>> int findPosition(T[] sortedArray, T value, int size){
        int start = 0;
        int end = size - 1;
        int mid = (start + end)/2;

        while (start <= end) {
            if (sortedArray[mid].compareTo(value) < 0){
                start = mid + 1;
            } else if (sortedArray[mid].compareTo(value) == 0) {
                return mid;
            } else {
                end = mid - 1;
            }
            mid = (start + end) / 2;
        }

        return start;
    }

    public static <T> void insert(T[] myArray, T value, int position, int size) {
        for (int i = size - 1; i >= position; i--) {
            myArray[i+1] = myArray[i];
        }
        myArray[position] = value;
    }
}
