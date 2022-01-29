package com.company.LinkedLists;

public class ReturnKthToLast {

    public static LinkedListNode createNode(int val){
        return new LinkedListNode(val);
    }

    public static LinkedListNode nthToLast(LinkedListNode head, int k){
        LinkedListNode p1 = head;
        LinkedListNode p2 = head;
        for(int i=0; i < k; i++){
            if(p1 == null){
                return null;
            }
            p1 = p1.next;
        }

        while(p1 != null){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
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
        obj.LinkedListTraversal(nthToLast(head, 2));
    }
}
