package com.company.LinkedLists;

public class Intersection {

    public static LinkedListNode createNode(int val) {
        return new LinkedListNode(val);
    }

    public static int intersection(LinkedListNode h1, LinkedListNode h2){
        LinkedListNode k = h2;
        while(h1 != null){
            while(h2 != null){
                if(h1 == h2){
                    return h1.val;
                }
                h2 = h2.next;
            }
            h2 = k;
            h1 = h1.next;
        }
        return -1;
    }

    public static void main(String []args){
        // Create  a Linked List
        LinkedListNode head, n1, n2, n3, n4, n5, n6;
        head = createNode(10);
        n1 = createNode(20);
        n2 = createNode(30);
        n3 = createNode(40);
        n4 = createNode(50);
        n5 = createNode(60);
        n6 = createNode(70);

        head.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = null;

        LinkedListNode head2, k1, k2, k3;
        head2 = createNode(1);
        k1 = createNode(2);
        k2 = createNode(3);
        k3 = createNode(4);

        head2.next = k1;
        k1.next = k2;
        k2.next = k3;
        k3.next = n4;

        LinkedListNode obj = new LinkedListNode();
        obj.LinkedListTraversal(head);
        System.out.println();
        obj.LinkedListTraversal(head2);
        System.out.println();
        System.out.println("Is Palindromic Linked List: " + intersection(head, head2));
    }
}
