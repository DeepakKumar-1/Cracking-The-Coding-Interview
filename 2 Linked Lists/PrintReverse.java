package com.company.LinkedLists;

public class PrintReverse {

    public static LinkedListNode createNode(int val) {
        return new LinkedListNode(val);
    }

    public static void printReverse(LinkedListNode head){
        if(head == null){
            return;
        }
        printReverse(head.next);
        System.out.print(head.val + " -> ");
    }

    public static void main(String []args){
        // Create  a Linked List
        LinkedListNode head, n1, n2, n3;
        head = createNode(2);
        n1 = createNode(3);
        n2 = createNode(2);
        n3 = createNode(4);

        head.next = n1;
        n1.next = n2;
        n2.next = n3;

        LinkedListNode obj = new LinkedListNode();
        obj.LinkedListTraversal(head);
        System.out.println();
        printReverse(head);
    }
}
