package com.example;

import java.util.LinkedList;
import java.util.stream.IntStream;

/**
 * Write method to return/find kth element from last element of the linked list
 */
public class KthFromLastElement {

    public static <T> T findKthToLastElement(LinkedListNode<T> list, int k) {

        if(k<=0){
            throw new RuntimeException("k should be a positive number");
        }
        LinkedListNode<T> pointerToReturnKthLastElement = list;
        LinkedListNode<T> pointerToReachEndOfList = list;

        for (int i = 0; i < k; i++) {
            if (pointerToReachEndOfList.next != null) {
                pointerToReachEndOfList = pointerToReachEndOfList.next;
            } else {
                throw new RuntimeException("List has less than " + k + " elements.");
            }
        }

        while(pointerToReachEndOfList != null){
            pointerToReturnKthLastElement = pointerToReturnKthLastElement.next;
            pointerToReachEndOfList = pointerToReachEndOfList.next;
        }

        return pointerToReturnKthLastElement.data;

    }


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

        System.out.println(findKthToLastElement(firstNode, 3));

        System.out.println(findKthToLastElement(firstNode, 5));

        System.out.println(findKthToLastElement(firstNode, 15));

        System.out.println(findKthToLastElement(firstNode, 0));



    }

}
