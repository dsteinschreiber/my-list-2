package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MyArrayBasedListTest {

    @Test
    public void isEmptyTest() {
        assertTrue(MyArrayBasedList.of().isEmpty());
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


}
