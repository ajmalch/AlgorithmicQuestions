package com.example;

/**
 * Given the middle node of  a linked list delete it
 * Constraint  input node should not be first or last;
 */
public class DeleteMiddleNode {

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

        System.out.println("Before deleting ");
        System.out.println( firstNode.printForward());
        deleteMiddleNode(node5);
        System.out.println("After deleting");
        System.out.println(firstNode.printForward());

    }

    static <T> void deleteMiddleNode(LinkedListNode<T> list){

        if(list==null || list.next ==null ){
            throw new RuntimeException("Unacceptable input");
        }

        list.data = list.next.data;
        list.next = list.next.next;

    }
}
