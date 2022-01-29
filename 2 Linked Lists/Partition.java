package com.company.LinkedLists;

public class Partition {
    public static LinkedListNode createNode(int val) {
        return new LinkedListNode(val);
    }

    public static LinkedListNode partition(LinkedListNode node, int x) {
        LinkedListNode list1 = new LinkedListNode(0);
        LinkedListNode l1 = list1;
        LinkedListNode list2 = new LinkedListNode(0);
        LinkedListNode l2 = list2;
        while (node != null) {
            if (node.val < x) {
                l1.next = new LinkedListNode(node.val);
                l1 = l1.next;
            } else {
                l2.next = new LinkedListNode(node.val);
                l2 = l2.next;
            }
            node = node.next;
        }
        l1.next = list2.next;
        return list1.next;
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
        obj.LinkedListTraversal(partition(head, 3));
    }
}
