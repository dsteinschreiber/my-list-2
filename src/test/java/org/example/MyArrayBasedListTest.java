package org.example;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class MyArrayBasedListTest {

    @Test
    public void isEmptyTest() {
        assertTrue(MyArrayBasedList.of(Integer.class).isEmpty());
        assertFalse(MyArrayBasedList.of(1).isEmpty());
    }

    @Test
    public void firstTest() {
        MyArrayBasedList test = MyArrayBasedList.of(1,2,3);
        assertEquals(1, test.first());
        assertNotEquals(3, test.first());
    }

    @Test
    public void lastTest() {
        MyArrayBasedList test = MyArrayBasedList.of(1,2,3);
        assertEquals(3, test.last());
        assertNotEquals(1, test.last());
    }


    @Disabled
    @Test
    public void sortTest() {
        MyArrayBasedList test = MyArrayBasedList.of(1,3,2,4);
        System.out.println(test.sort());
    }



    @Disabled
    @Test
    public void equalsTest() {

    }

    @Test
    public void containsTest(){
        assertTrue(MyArrayBasedList.of(1,2,3).contains(1));
        assertTrue(MyArrayBasedList.of(1,3,2,4).sort().contains(2));
        assertFalse(MyArrayBasedList.of(5,6,7,8,8,9,11).sort().contains(70));
        assertTrue(MyArrayBasedList.of(5,6,7,8,8,9,11).sort().contains(8));
        assertTrue(MyArrayBasedList.of(3,2,1).sort().contains(3));
    }

    @Test
    public void randomTest(){
        Integer[] test = new Integer[10];
        test[0] = 2;
        test[1] = 4;
        test[2] = 6;
        test[3] = 8;
        test[4] = 10;
//
//        MyArrayBasedList.insert(test,3,2,10);
//        MyArrayBasedList.insert(test,5,4,10);
//
//        Arrays.stream(test).forEach(value -> System.out.println(value));

        System.out.println(MyArrayBasedList.findPosition(test,1, 5)); // 0
        System.out.println(MyArrayBasedList.findPosition(test,3, 5)); // 1
        System.out.println(MyArrayBasedList.findPosition(test,5, 5)); // 2
        System.out.println(MyArrayBasedList.findPosition(test,7, 5)); // 3
        System.out.println(MyArrayBasedList.findPosition(test,9, 5)); // 4


    }

}
