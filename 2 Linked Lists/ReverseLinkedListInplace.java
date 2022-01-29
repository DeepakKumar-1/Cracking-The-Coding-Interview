package com.company.LinkedLists;

public class ReverseLinkedListInplace {

    public static LinkedListNode createNode(int val) {
        return new LinkedListNode(val);
    }

    public static LinkedListNode reverse(LinkedListNode head){
        LinkedListNode prev = null;
        LinkedListNode next ;
        LinkedListNode current = head;
        while(current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
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
        obj.LinkedListTraversal(reverse(head));
    }
}
