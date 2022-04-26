package org.example;

import java.util.Iterator;

public class MyLinkedListIterator<T> implements Iterator<T> {

    private final MyLinkedList<T> linkedListInstance;

    private MyLinkedListElement<T> cursor;

    public MyLinkedListIterator(MyLinkedList<T> linkedListInstance){
        this.linkedListInstance = linkedListInstance;
        this.cursor = linkedListInstance.firstElement;
    }


    @Override
    public boolean hasNext() {
        return this.cursor != null;
    }

    @Override
    public T next() {
        MyLinkedListElement<T> lastCursor = this.cursor;
        this.cursor = this.cursor.next;
        return lastCursor.value;
    }
}
