package org.example;

public class MyListUtils {
    public static <T> MyList<T> allFirsts(MyList<T>... lists){
        MyList<T> result = new MyLinkedList<>();

        for (MyList<T> list: lists){
            result.append(list.first());
        }

        return result;
    }

}
