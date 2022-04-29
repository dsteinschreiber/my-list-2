package org.example;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class MyLinkedListTest {

    @Test
    public void isEmptyTest() {
        assertTrue(MyLinkedList.of().isEmpty());
        assertFalse(MyLinkedList.of(1).isEmpty());
    }

    @Test
    public void firstTest() {
        assertEquals(1, MyLinkedList.of(1, 2, 3).first());
        assertNotEquals(1, MyLinkedList.of(2, 3, 4));
    }

    @Test
    public void lastTest() {
        assertEquals(1, MyLinkedList.of(3, 2, 1).last());
    }

    @Test
    public void restTest() {
        assertThrows(EmptyListException.class, () -> MyLinkedList.of().rest());
    }

    @Test
    public void pushTest() {
        assertEquals(MyLinkedList.of(1, 2, 3), MyLinkedList.of(2, 3).push(1));
    }

    @Test
    public void equalsTest() {
        assertEquals(MyLinkedList.of(), MyLinkedList.of());

        assertNotEquals(MyLinkedList.of(1, 2, 3, 4, 5), MyLinkedList.of(1, 2, 3, 4));

        assertEquals(MyLinkedList.of(1, 2, 3), MyLinkedList.of(1, 2).append(3));
    }

    @Test
    public void iteratorTest() {
        MyList<Integer> list1 = MyLinkedList.of(1, 2, 3);

        for (Integer value : list1) {
            System.out.println(value);
        }

    }

    @Test
    public void mapTest() {
        assertEquals(MyLinkedList.of(2, 4, 6), MyLinkedList.of(1, 2, 3).map(value -> value * 2));
        assertEquals(MyLinkedList.of(), MyLinkedList.of(1).rest().map(value -> value * 2));
    }


    @Disabled
    @Test
    public void genericTest() {
        assertTrue(Integer.valueOf(1) == Integer.valueOf(1));
        assertTrue("Hello" == "Hello");
        assertTrue("He" + "llo" == "Hello");
        assertTrue("Hello".toLowerCase().intern() == "hello");
    }
}
