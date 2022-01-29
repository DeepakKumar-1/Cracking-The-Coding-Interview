package com.company.LinkedLists;

public class DeleteMiddleNode {

    public static LinkedListNode createNode(int val){
        return new LinkedListNode(val);
    }

    public static LinkedListNode deleteMiddleNode(LinkedListNode head){
        if(head == null || head.next == null){
            return null;
        }
        // Count the Size of the Linked List
        LinkedListNode n = head;
        int count = 0;
        while(n != null){
            count++;
            n = n.next;
        }

        LinkedListNode prev = head;
        LinkedListNode current = head.next;
        for(int i=0; i< count/2 - 1; i++){
            if(current != null){
                current = current.next;
                prev = prev.next;
            }
        }
        // Delete this Node
        prev.next = current.next;
        return head;
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
        obj.LinkedListTraversal(deleteMiddleNode(head));
    }
}
