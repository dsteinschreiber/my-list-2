package org.example;

import java.util.function.BiFunction;
import java.util.function.Function;

public class MyLinkedList<T> implements MyList<T> {

    private MyLinkedListElement<T> firstElement;
    private MyLinkedListElement<T> lastElement;

    public static <T> MyLinkedList<T> of(T... values) {
        MyLinkedList<T> result = new MyLinkedList<>();

        for (T value : values) {
            result.append(value);
        }

        return result;
    }

    public static  MyLinkedList<Character> from(String string){
        MyLinkedList<Character> result = new MyLinkedList<>();

        for (char c: string.toCharArray()){
            result.append(c);
        }

        return result;
    }

    @Override
    public MyList<T> append(T value) {
        if (this.isEmpty()) {
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
        if (this.isEmpty()) {
            throw new EmptyListException();
        }

        MyLinkedList<T> result = new MyLinkedList<>();

        result.firstElement = this.firstElement.next;

        result.lastElement = this.lastElement;

        return result;
    }

    @Override
    public MyList<T> push(T value) {
        MyLinkedListElement<T> newElement = new MyLinkedListElement<>();

        newElement.value = value;

        newElement.next = this.firstElement;

        if (this.isEmpty()) {
            this.lastElement = newElement;
        }

        this.firstElement = newElement;

        return this;
    }

    @Override
    public T pop(){
        T result = this.firstElement.value;

        this.firstElement = this.firstElement.next;

        return result;
    }

    @Override
    public boolean equals(Object object) {

        if (object == null) {
            return false;
        }

        if (!(object instanceof MyList)) {
            return false;
        }

        MyList<T> that = (MyList<T>) object;

        for (T value : this) {
            if (that.isEmpty()) {
                return false;
            }

            if (!value.equals(that.first())) {
                return false;
            }
            that = that.rest();
        }

        if (!that.isEmpty()) {
            return false;
        }

        return true;
    }

    @Override
    public <V> MyList<V> map(Function<T, V > mapper){
        MyList<V> result = new MyLinkedList<V>();

        for (T value: this){
            result.append(mapper.apply(value));
        }

        return result;
    }

    @Override
    public <V> V reduce(V initialValue, BiFunction<V, T, V> accumulator) {
        V result = initialValue;

        for (T value: this){
            result = accumulator.apply(result, value);
        }

        return result;
    }

    @Override
    public boolean all(Function<T, Boolean> predicate) {

        for (T value: this){
            if (!predicate.apply(value)){
                return false;
            }
        }

        return true;
    }

    @Override
    public boolean allEquals() {

        MyList<T> comparedList = this;

        for (T value: this){
            if (comparedList.rest().isEmpty()){
                break;
            }

            if (!value.equals(comparedList.rest().first())){
                return false;
            }
            comparedList = comparedList.rest();
        }

        return true;
    }


    @Override
    public boolean any(Function<T, Boolean> predicate) {

        for (T value: this){
            if (predicate.apply(value)){
                return true;
            }
        }

        return false;
    }

    @Override
    public String toString(){
        String result = "[";

        String delimiter = "";

        for (T value: this){
            result = result + delimiter + value;
            delimiter = ", ";
        }

        result = result + "]";

        return result;
    }

}
