package com.company.LinkedLists;

import java.util.Scanner;

public class BuildLinkedList {

    public static LinkedListNode createNode(int val) {
        return new LinkedListNode(val);
    }

    public static void main(String []args){
        // Create  a Linked List
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Size of the Linked List: ");
        int n = sc.nextInt();
        LinkedListNode head = null;
        LinkedListNode ptr = null;
        System.out.print("Enter Values: ");
        for(int i=0; i<n; i++){
            int val = sc.nextInt();
            if(i == 0){
                 head = createNode(val);
                 ptr = head;
            } else {
                LinkedListNode currentNode = createNode(val);
                ptr.next = currentNode;
                ptr = currentNode;
            }

        }

        LinkedListNode obj = new LinkedListNode();
        obj.LinkedListTraversal(head);
        System.out.println();
    }

}
