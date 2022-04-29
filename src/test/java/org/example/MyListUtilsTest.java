package org.example;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.example.MyListUtils.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MyListUtilsTest {

    @Test
    public void allFirstsTest() {
        assertEquals(MyLinkedList.of(1, 2, 3),
                allFirsts(MyLinkedList.of(1, 2, 3),
                        MyLinkedList.of(2, 3, 4),
                        MyLinkedList.of(3, 4, 5)));
    }

    @Test
    public void toStringTest() {
        assertEquals("Hello", MyListUtils.toString(MyLinkedList.from("Hello")));
        assertEquals("", MyListUtils.toString(MyLinkedList.from("")));
    }


    @Disabled
    @Test
    public void longestCommonPrefixTest() {
        assertEquals("ass", longestCommonPrefix(MyLinkedList.of("assassin","assembly", "assert")));
        assertEquals("", longestCommonPrefix(MyLinkedList.of()));
        assertEquals("ass", longestCommonPrefix(MyLinkedList.of("assassin", "assembly", "assert")));
    }
}
