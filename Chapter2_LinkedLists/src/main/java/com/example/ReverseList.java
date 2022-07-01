package com.example;

/**
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 */

public class ReverseList {

    public ListNode reverseList(ListNode head) {

        ListNode ptr = head;
        ListNode prev = null;

        while (ptr != null) {
            ListNode next = ptr.next;
            ptr.next = prev;
            prev = ptr;
            ptr = next;
        }

        return prev;

    }
}
