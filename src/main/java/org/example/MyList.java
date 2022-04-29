package org.example;

import java.util.Iterator;
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
}
