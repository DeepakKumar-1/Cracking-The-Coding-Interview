package com.company.LinkedLists;

public class DeleteMiddleNode2 {

    public static LinkedListNode createNode(int val) {
        return new LinkedListNode(val);
    }

    public static LinkedListNode deleteMiddleNode(LinkedListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        LinkedListNode slow = head;
        LinkedListNode fast = head.next.next;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        slow.next =  slow.next.next;
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
