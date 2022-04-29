package org.example;

import org.junit.jupiter.api.Test;

import static org.example.MyListUtils.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyListUtilsTest {
    @Test
    public void allFirstsTest() {
        assertEquals(MyLinkedList.of(1, 2, 3),
                allFirsts(MyLinkedList.of(1, 2, 3),
                        MyLinkedList.of(2, 3, 4),
                        MyLinkedList.of(3, 4, 5)));
    }

}
