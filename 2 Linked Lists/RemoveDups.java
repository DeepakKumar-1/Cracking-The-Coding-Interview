package com.company.LinkedLists;

import java.util.HashSet;
import java.util.Set;

public class RemoveDups {

    public static LinkedListNode createNode(int val){
        return new LinkedListNode(val);
    }

    public static void deleteDups(LinkedListNode n){
        Set<Integer> set = new HashSet<>();
        LinkedListNode prev = null;
        while(n != null){
            if(set.contains(n.val)){
                prev.next = n.next;
            } else{
                set.add(n.val);
                prev = n;
            }
            n = n.next;
        }
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
        deleteDups(head);
        System.out.println();
        obj.LinkedListTraversal(head);
    }
}
