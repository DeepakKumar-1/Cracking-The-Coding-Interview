package com.company.LinkedLists;

public class CycleDetection {

    public static LinkedListNode createNode(int val) {
        return new LinkedListNode(val);
    }

    public static boolean hasCycle(LinkedListNode head){
        LinkedListNode slow, fast;
        slow = fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }

    public static void main(String []args){
        // Create  a Linked List
        LinkedListNode head, n1, n2, n3, n4, n5, n6, n7;
        head = createNode(1);
        n1 = createNode(2);
        n2 = createNode(3);
        n3 = createNode(4);
        n4 = createNode(5);
        n5 = createNode(6);
        n6 = createNode(7);
        n7 = createNode(8);

        head.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = n3;

        System.out.println();
        System.out.println("Has Cycle: " + hasCycle(head));
    }
}
