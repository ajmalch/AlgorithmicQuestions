package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class MergeSortedListTest {


    @Test
    void mergeTwoLists() {
        ListNode node1 = new ListNode(2);
        node1.next = new ListNode(6);
        node1.next.next = new ListNode(7);
        node1.next.next.next = new ListNode(8);


        ListNode node2 = new ListNode(1);
        node2.next = new ListNode(3);
        node2.next.next = new ListNode(4);
        node2.next.next.next = new ListNode(5);
        node2.next.next.next.next = new ListNode(9);
        node2.next.next.next.next.next = new ListNode(10);

        final var mergeSortedList = new MergeSortedList();

        final var mergedList = mergeSortedList.mergeTwoLists(node1, node2);

        assertEquals(1, mergedList.val);
        assertEquals(2, mergedList.next.val);
        assertEquals(3, mergedList.next.next.val);
        assertEquals(4, mergedList.next.next.next.val);
        assertEquals(5, mergedList.next.next.next.next.val);
        assertEquals(6, mergedList.next.next.next.next.next.val);
        assertEquals(7, mergedList.next.next.next.next.next.next.val);
        assertEquals(8, mergedList.next.next.next.next.next.next.next.val);
        assertEquals(9, mergedList.next.next.next.next.next.next.next.next.val);
        assertEquals(10, mergedList.next.next.next.next.next.next.next.next.next.val);
        assertNull(mergedList.next.next.next.next.next.next.next.next.next.next);


    }
}