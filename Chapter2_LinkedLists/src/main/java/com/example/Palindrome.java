package com.example;

/**
 * Implement a function to check if the linked list of characters is a palindrome
 */
public class Palindrome {


    //O(n) for both time and space complexity
    public boolean isPalindrome(LinkedListNode<Character> node) {

        LinkedListNode<Character> reversed = reverseList(node);

        LinkedListNode<Character> curr = node;

        while (curr != null && reversed != null) {

            if (curr.data != reversed.data)
                return false;

            curr = curr.next;
            reversed = reversed.next;
        }

        if (curr != null || reversed != null) {
            return false;
        }

        return true;
    }

    private LinkedListNode<Character> reverseList(LinkedListNode<Character> node) {

        LinkedListNode<Character> prev = null;
        LinkedListNode<Character> curr = node;

        while (curr != null) {
            LinkedListNode<Character> newNode = new LinkedListNode<>();
            newNode.data = curr.data;
            newNode.next = prev;
            prev = newNode;
            curr = curr.next;
        }

        return prev;
    }


    public static void main(String[] args) {

        Palindrome palindrome = new Palindrome();

        LinkedListNode<Character> node1 = new LinkedListNode<>();
        node1.data = 'c';
        LinkedListNode<Character> node2 = new LinkedListNode<>();
        node2.data = 'a';
        LinkedListNode<Character> node3 = new LinkedListNode<>();
        node3.data = 'd';
        LinkedListNode<Character> node4 = new LinkedListNode<>();
        node4.data = 'a';
        LinkedListNode<Character> node5 = new LinkedListNode<>();
        node5.data = 'c';

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        System.out.println(palindrome.isPalindrome(node1));

    }

}
