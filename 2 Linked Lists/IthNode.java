package com.company.LinkedLists;

public class IthNode {

    public static LinkedListNode createNode(int val) {
        return new LinkedListNode(val);
    }

    public static void ithNode(LinkedListNode head, int k){
        if(head == null){
            System.out.println("Empty Linked List !!");
        }
        LinkedListNode node = head;
        boolean foundNode = false;
        for(int i=0; i<k-1; i++){
            if(node == null){
                System.out.println("Wrong Input No Such Node Exist");
                foundNode = true;
            } else {
                node = node.next;
            }
        }
        if(!foundNode) {
            System.out.println(node.val);
        }

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
        ithNode(head, 3);
    }

}
