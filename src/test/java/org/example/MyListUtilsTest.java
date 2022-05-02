package org.example;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.example.MyLinkedList.from;
import static org.example.MyLinkedList.of;
import static org.example.MyListUtils.*;
import static org.junit.jupiter.api.Assertions.*;

public class MyListUtilsTest {

    @Test
    public void allFirstsTest() {
        assertEquals(MyLinkedList.of(1, 2, 3),
                allFirsts(of(MyLinkedList.of(1, 2, 3),
                        MyLinkedList.of(2, 3, 4),
                        MyLinkedList.of(3, 4, 5))));
    }

    @Test
    public void allRestsTest() {
        assertEquals(of(from("ssert"), from("ssembly"), from("ssassin")),
                allRests(of(from("assert"), from("assembly"), from("assassin"))));
    }

    @Test
    public void toStringTest() {
        assertEquals("Hello", MyListUtils.toString(MyLinkedList.from("Hello")));
        assertEquals("", MyListUtils.toString(MyLinkedList.from("")));
    }

    @Test
    public void allEqualsTest() {
        assertTrue(allEquals("ssss"));
        assertFalse(allEquals("sssa"));
        assertTrue(allEquals(""));
    }

    @Test
    public void longestCommonPrefixLengthTest() {
        assertEquals(3, longestCommonPrefixLength(of(from("assassin"), from("assert"), from("assembly"))));
        assertEquals(0, longestCommonPrefixLength(of(from("assassin"), from(""), from("assert"))));
        assertEquals(0, longestCommonPrefixLength(MyLinkedList.of()));
    }

    @Test
    public void longestCommonPrefixTest() {
        assertEquals("ass", longestCommonPrefix("assassin", "assert", "assembly"));
        assertEquals("", longestCommonPrefix(""));
        assertEquals("", longestCommonPrefix("assassin","whimberly","driftwood"));
        assertEquals("", longestCommonPrefix());

    }
}
