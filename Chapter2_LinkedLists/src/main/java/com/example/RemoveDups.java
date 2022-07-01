package com.example;

import java.util.HashSet;
import java.util.Set;

/**
 * Write a code to remove duplicate elements from an unsorted link list
 * Write method which does not use a temporary buffer data structure
 */
public class RemoveDups {

    public static void main(String[] args) {

        LinkedListNode<String> firstNode = new LinkedListNode<>("Ajmal");
        LinkedListNode<String> secondNode = new LinkedListNode<>("Shadiya");
        LinkedListNode<String> node3 = new LinkedListNode<>("Ajmal");
        LinkedListNode<String> node4 = new LinkedListNode<>("Haniya");
        LinkedListNode<String> node5 = new LinkedListNode<>("Maliha");
        LinkedListNode<String> node6 = new LinkedListNode<>("Ajmal");
        LinkedListNode<String> node7 = new LinkedListNode<>("Aqila");
        LinkedListNode<String> lastNode = new LinkedListNode<>("Haniya");

        firstNode.setNext(secondNode);
        secondNode.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        node5.setNext(node6);
        node6.setNext(node7);
        node7.setNext(lastNode);

        System.out.println("Original list :" + firstNode.printForward());
        removeDupsNoBuffer(firstNode);
        System.out.println("Removed Duplicates : " + firstNode.printForward());


    }

    /**
     * Time complexity O(n) and space complexity O(n)
     * @param linkedListNode
     */
    static void removeDups(LinkedListNode<String> linkedListNode){

        LinkedListNode<String> current = linkedListNode;
        LinkedListNode<String> previous = null;

        Set<String> set = new HashSet<>();

        while (current != null){

            if(set.contains(current.data)){
                previous.next = current.next;
            }else {
                set.add(current.data);
                previous = current;
            }

            current = current.next;

        }
    }

    /**
     * Time complexity O(n^2) and space complexity O(1)
     * @param linkedListNode
     */
    static void removeDupsNoBuffer(LinkedListNode<String> linkedListNode){

        LinkedListNode<String> current = linkedListNode;

        while (current != null){
            LinkedListNode<String> runner = current;
            while(runner.next != null){
                if(runner.next.data.equals(current.data)){
                    runner.next = runner.next.next;
                }else{
                    runner = runner.next;
                }
            }

            current = current.next;

        }
    }
}
