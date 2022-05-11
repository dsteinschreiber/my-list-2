package org.example;

public class MySortedList <T extends Comparable <T>> extends MyArrayBasedList<T>{


    // Calls parent class constructor
    public MySortedList(Class<T> classToken, int length) {
        super(classToken, length);
    }

    public static MySortedList<Integer> of(Integer... values) {
        return of(Integer.class, values);
    }

    public static MySortedList<String> of(String... values) {
        return of(String.class, values);
    }


    public static <T extends Comparable<T>> MySortedList<T> of(Class<T> classToken, T... values) {
        MySortedList<T> result = new MySortedList<>(classToken, values.length);

        for (T value : values) {
            result.add(value);
        }

        return result;
    }

    public MySortedList<T> add(T value) {
        if (this.size == 0){
            this.myArray[0] = value;
        } else {
            int position = MyArrayBasedList.findPosition(this.myArray, value, this.size);
            MyArrayBasedList.insert(this.myArray, value, position, this.size);
        }
        this.size++;
        return this;
    }
}
