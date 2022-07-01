package com.example;


/**
 * Given a linked list of integers and a number
 * Return a linked list such a way that all elements less than the input number should be before the
 * elements equal or greater than the input elements
 */
public class PartitionLinkedList {

    public static void main(String[] args) {
        LinkedListNode<Integer> firstNode = new LinkedListNode<>(2);
        LinkedListNode<Integer> secondNode = new LinkedListNode<>(7);
        LinkedListNode<Integer> node3 = new LinkedListNode<>(10);
        LinkedListNode<Integer> node4 = new LinkedListNode<>(4);
        LinkedListNode<Integer> node5 = new LinkedListNode<>(5);
        LinkedListNode<Integer> node6 = new LinkedListNode<>(41);
        LinkedListNode<Integer> node7 = new LinkedListNode<>(5);
        LinkedListNode<Integer> lastNode = new LinkedListNode<>(3);

        firstNode.setNext(secondNode);
        secondNode.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        node5.setNext(node6);
        node6.setNext(node7);
        node7.setNext(lastNode);

        System.out.println("Before partitioning ");
        System.out.println( firstNode.printForward());
        System.out.println("After partitioning with number 5");
        System.out.println( partition(firstNode, 5).printForward());
    }


    static LinkedListNode<Integer> partition(LinkedListNode<Integer> list,int number ){

        LinkedListNode<Integer> node = list;

        LinkedListNode<Integer> head = node;
        LinkedListNode<Integer> tail = node;

        while(node != null){
            LinkedListNode<Integer> next = node.next;
            if(node.data < number){
                node.next = head;
                head = node;
            }else{
                tail.next = node;
                tail = node;
            }
            node = next;
        }

        tail.next= null;

        return head;
    }
}
