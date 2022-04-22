package org.example;

public interface MyList<T> extends Iterable<T>{
    MyList<T> append(T element);
    T first();
    T last();
    boolean isEmpty();
    MyList<T> rest();
    MyList<T> push(T element);

}
