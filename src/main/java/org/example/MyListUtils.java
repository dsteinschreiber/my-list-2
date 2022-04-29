package org.example;

public class MyListUtils {
    public static <T> MyList<T> allFirsts(MyList<T>... lists){
        MyList<T> result = new MyLinkedList<>();

        for (MyList<T> list: lists){
            result.append(list.first());
        }

        return result;
    }

    public static String toString(MyLinkedList<Character> list){
//        String result = "";
//
//        for (Character c: list){
//            result = result + c;
//        }
//
//        return result;

        return list.reduce("", (result, value) -> result + value);

    }

    public static boolean allEquals (String string){
        return MyLinkedList.from(string).allEquals();
    }



    public static <T> MyList<T> longestCommonPrefix(MyList<T>... lists){
//        String result = "";
//
//        MyList<String> checkingList = new MyLinkedList<>();
//
//        for (MyList<String> list: lists){
//
//
//        }
//
//
//
//        return result;
        return null;
    }

}
