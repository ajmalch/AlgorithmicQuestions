package com.example;

/**
 * You have two numbers represented by two linked list where each node contain a single digit.
 * The digits are stored in reverse order, such that 1's digit is at the head of the list.
 *  Write a function that add the two numbers and return a linked list that represent the sum.
 *
 *  Example
 *  input (7-> 1->6) +  (5->9->2) = 617+ 295
 *  output  (2 -> 1 -> 9) = 912
 *
 *  Suppose the digits are stored in forward order. Repeat the above problem
 *
 * input ( 6->1->7) + (2->9->5) = 617 + 295
 * outp  ( 9->1->2) = 912
 *
 */


public class SumLists {

    public static void main(String[] args) {
        LinkedListNode<Integer> n11 = new LinkedListNode<>(7);
        LinkedListNode<Integer> n12 = new LinkedListNode<>(1);
        LinkedListNode<Integer> n13 = new LinkedListNode<>(6);
        n11.setNext(n12);
        n12.setNext(n13);


        LinkedListNode<Integer> n21 = new LinkedListNode<>(5);
        LinkedListNode<Integer> n22 = new LinkedListNode<>(9);
        LinkedListNode<Integer> n23 = new LinkedListNode<>(2);
        n21.setNext(n22);
        n22.setNext(n23);

        System.out.println("input");
        System.out.println(n11.printForward());
        System.out.println(n21.printForward());

        System.out.println("output ");
        final LinkedListNode<Integer> addLists = addLists(n11, n21, 0);
        if(addLists != null) System.out.println(addLists.printForward());
        System.out.println(addForwardLists(n11, n21).printForward());

    }

    private static LinkedListNode<Integer> addLists(LinkedListNode<Integer> list1, LinkedListNode<Integer> list2 , int carry) {

        if(list1 == null && list2 == null && carry == 0)
            return  null;

        LinkedListNode<Integer> result = new LinkedListNode<>();
        int value = carry;

        if(list1 != null ){
            value += list1.data;
        }
        if(list2 != null ){
            value += list2.data;
        }
        result.data = value%10;

        if(list1 != null || list2 !=null){
            result.setNext(addLists(list1==null?null:list1.next
                    ,list2 ==null ? null:list2.next, value>=10?1:0));
        }

        return result;
    }


    private static LinkedListNode<Integer> addForwardLists(LinkedListNode<Integer> list1, LinkedListNode<Integer> list2){

        final var l1 = length(list1);
        final var l2 = length(list2);

        //swap the lists
        if(l1>l2) {
            LinkedListNode<Integer> temp = list1;
            list1 = list2;
            list2 = temp;
        }

        int i= l1-l2;
        for (int j = 0; j < i; j++) {
            LinkedListNode<Integer> zeroNode = new LinkedListNode<>(0);
            zeroNode.setNext(list1);
            list1 = zeroNode;
        }

        LinkedListNode<Integer> result = new LinkedListNode<>(0);
        LinkedListNode<Integer> resultRunner = result;

        while (list1 != null){

            resultRunner.next = new LinkedListNode<>((list1.data + list2.data) % 10);
            if(list1.data + list2.data >= 10) {
                resultRunner.data = resultRunner.data+1;
            }
            resultRunner = resultRunner.next;
            list1 = list1.next;
            list2 = list2.next;
        }


        return  result.data==0?result.next:result;

    }

    private static int length(LinkedListNode<Integer> list){
        int length = 0;
        LinkedListNode<Integer> node = list;
        while(node !=null){
            length++;
            node = node.next;
        }

        return length;
    }

}
