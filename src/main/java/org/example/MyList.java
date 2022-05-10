package org.example;

import com.fasterxml.jackson.annotation.JsonValue;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public interface MyList<T> extends Iterable<T> {
    MyList<T> append(T value);

    T first();

    T last();

    boolean isEmpty();

    MyList<T> rest();

    MyList<T> push(T value);

    @Override
    default Iterator<T> iterator() {
//        return new MyListIterator<T>(this);
        MyList<T> self = this;
        return new Iterator<T>() {

            private MyList<T> listInstance = self;

            @Override
            public boolean hasNext() {
                return !this.listInstance.isEmpty();
            }

            @Override
            public T next() {
                T lastValue = this.listInstance.first();
                this.listInstance = this.listInstance.rest();
                return lastValue;
            }
        };
    }

    <V> MyList<V> map(Function<T, V> mapper);

    <V> V reduce(V initialValue, BiFunction<V, T, V> accumulator);

    boolean all(Function<T, Boolean> predicate);

    boolean allEquals();

    boolean any(Function<T, Boolean> predicate);

    @JsonValue
    default List<T> toList() {
        List<T> result = new ArrayList<>();

        for (T value: this){
            result.add(value);
        }

        return result;
    }

}
