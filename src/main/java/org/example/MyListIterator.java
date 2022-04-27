package org.example;

import java.util.Iterator;

public class MyListIterator<T> implements Iterator<T> {

    private MyList<T> listInstance;


    public MyListIterator(MyList<T> listInstance){
        this.listInstance = listInstance;
    }

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
}
