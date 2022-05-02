package org.example;

import static org.example.MyLinkedList.from;

public class MyListUtils {
    public static <T> MyList<T> allFirsts(MyList<MyList<T>> lists) {
        MyList<T> methodResult = new MyLinkedList<>();

//        for (MyList<T> list: lists){
//            methodResult.append(list.first());
//        }

        return lists.reduce(methodResult, (result, value) -> result.append(value.first()));
    }

    public static <T> MyList<MyList<T>> allRests(MyList<MyList<T>> lists) {
        MyList<MyList<T>> results = new MyLinkedList<>();
//
//        for (MyList<T> list: lists){
//            results.append(list.rest());
//        }

        return lists.reduce(results, (result, value) -> result.append(value.rest()));

    }


    public static String toString(MyLinkedList<Character> list) {
//        String result = "";
//
//        for (Character c: list){
//            result = result + c;
//        }
//
//        return result;

        return list.reduce("", (result, value) -> result + value);

    }

    public static boolean allEquals(String string) {
        return from(string).allEquals();
    }

    public static <T> int longestCommonPrefixLength(MyList<MyList<T>> lists) {
        int result = 0;

        MyList<MyList<T>> rests = lists;

        if (lists.isEmpty()) {
            return result;
        }

        while (!rests.any(value -> value.isEmpty()) && allFirsts(rests).allEquals()) {
            result++;
            rests = allRests(rests);
        }

        return result;
    }

    public static String longestCommonPrefix(String... strings) {
        MyList<MyList<Character>> listOfCharList = new MyLinkedList<>();

        String result = "";

        if (strings.length == 0) {
            return result;
        }

        for (String string : strings) {
            listOfCharList.append(from(string));
        }

        int counter = longestCommonPrefixLength(listOfCharList);

        MyList<Character> myFirst = listOfCharList.first();

        for (int i = 0; i < counter; i++) {
            result = result + myFirst.first();
            myFirst = myFirst.rest();
        }

        return result;
    }

}
