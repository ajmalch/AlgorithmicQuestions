package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
 * <p>
 * Merge all the linked-lists into one sorted linked-list and return it.
 */

public class MergeKSortedKLists {

    public ListNode mergeKLists(ListNode[] lists) {

        if (lists.length == 0)
            return null;

        List<ListNode> listOfLists = Arrays.asList(lists);

        List<ListNode> currentList = listOfLists;

        while (currentList.size() > 1) {

            List<ListNode> newList = new ArrayList<>();
            int i = 0;
            while (i < currentList.size() - 1) {
                newList.add(mergeTwoLists(currentList.get(i), currentList.get(i + 1)));
                i = i + 2;
            }
            if (i == currentList.size() - 1)
                newList.add(currentList.get(currentList.size() - 1));
            currentList = newList;
        }

        return currentList.get(0);

    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode dummyNode = new ListNode(-1);
        ListNode prev = dummyNode;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        prev.next = l1 == null ? l2 : l1;

        return dummyNode.next;
    }
}
