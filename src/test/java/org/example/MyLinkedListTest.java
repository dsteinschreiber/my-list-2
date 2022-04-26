package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MyLinkedListTest {

    @Test
    public void isEmptyTest(){
        assertTrue(MyLinkedList.of().isEmpty());
        assertFalse(MyLinkedList.of(1).isEmpty());
    }

    @Test
    public void firstTest(){
        assertEquals(1, MyLinkedList.of(1,2,3).first());
        assertNotEquals(1, MyLinkedList.of(2,3,4));
    }

    @Test
    public void lastTest(){
        assertEquals(1, MyLinkedList.of(3,2,1).last());
    }

    @Test
    public void restTest(){

    }

    @Test
    public void pushTest(){

    }
}
