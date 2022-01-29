package com.company.LinkedLists;

public class Increment {

    public static LinkedListNode createNode(int val) {
        return new LinkedListNode(val);
    }

    public static void increment(LinkedListNode head){
        LinkedListNode node = head;
        while(node != null){
            node.val++;
            node = node.next;
        }
        System.out.println();
    }
    public static void main(String []args){
        // Create  a Linked List
        LinkedListNode head, n1, n2, n3;
        head = createNode(2);
        n1 = createNode(3);
        n2 = createNode(2);
        n3 = createNode(2);

        head.next = n1;
        n1.next = n2;
        n2.next = n3;

        LinkedListNode obj = new LinkedListNode();
        obj.LinkedListTraversal(head);
        System.out.println();
        increment(head);
        System.out.println("Linked List After Increment: " );
        obj.LinkedListTraversal(head);
    }

}
