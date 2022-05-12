package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MySortedListTest {

    @Test
    public void addTest() {
        System.out.println(MySortedList.of(3,2,1));
        System.out.println(MySortedList.of(9,4,12,55,9,2,0,3,-11));
    }

    @Test
    public void containsTest() {
        assertTrue(MySortedList.of(9,4,12,55,9,2,0,3,-11).contains(9));
        assertFalse(MySortedList.of(9,4,12,55,9,2,0,3,-11).contains(100));
    }



}
