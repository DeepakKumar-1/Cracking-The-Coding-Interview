package com.company.LinkedLists;

public class AppendLastNToFirst {

    public static LinkedListNode createNode(int val) {
        return new LinkedListNode(val);
    }

    public static LinkedListNode appendLastNToFirst(LinkedListNode head, int k){
        if(k == 0 || head == null){
            return head;
        }

        LinkedListNode fast = head;
        LinkedListNode slow = head;
        for(int i=0; i<k; i++){
            fast = fast.next;
        }

        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        LinkedListNode temp = slow.next;
        slow.next = null;
        fast.next = head;
        head = temp;

        return head;
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
        obj.LinkedListTraversal(appendLastNToFirst(head, 3));
    }
}
