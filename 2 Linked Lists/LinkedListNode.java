package com.company.LinkedLists;

public class LinkedListNode {
    int val;
    LinkedListNode next;
    public LinkedListNode(int val){
        this.val = val;
    }

    public LinkedListNode() { }

    public void LinkedListTraversal(LinkedListNode n){
        if(n == null){
            System.out.println("Linked List is Empty");
        }
        while(n != null){
            System.out.print(n.val + " -> ");
            n = n.next;
        }
    }
}
