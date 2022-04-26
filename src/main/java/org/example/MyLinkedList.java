package org.example;

import java.util.Iterator;

public class MyLinkedList <T> implements MyList<T>{

    private MyLinkedListElement<T> firstElement;
    private MyLinkedListElement<T> lastElement;

    public static <T> MyList<T> of(T... values){
        MyLinkedList<T> result = new MyLinkedList<>();

        for (T value: values){
            result.append(value);
        }

        return result;
    }

    @Override
    public MyList<T> append(T value) {
        if (this.isEmpty()){
            return this.push(value);
        }

        MyLinkedListElement newElement = new MyLinkedListElement();

        newElement.value = value;

        this.lastElement.next = newElement;

        this.lastElement = newElement;

        return this;
    }

    @Override
    public T first() {
        return this.firstElement.value;
    }

    @Override
    public T last() {
        return this.lastElement.value;
    }

    @Override
    public boolean isEmpty() {
        return this.firstElement == null;
    }

    @Override
    public MyList<T> rest() {
        MyLinkedList<T> result = new MyLinkedList<>();

        result.firstElement = this.firstElement.next;

        return result;
    }

    @Override
    public MyList<T> push(T value) {
        MyLinkedListElement<T> newElement = new MyLinkedListElement<>();

        newElement.value = value;

        newElement.next = this.firstElement;

        if (this.isEmpty()){
            this.lastElement = newElement;
        }

        this.firstElement = newElement;

        return this;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
